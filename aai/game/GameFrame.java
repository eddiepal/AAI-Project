package aai.game;

import aai.behaviour.AccelerateHorizontalBehaviour;
import aai.behaviour.PursuitBehaviour;
import aai.entity.Vehicle;
import aai.util.Vector2D;
import aai.world.World;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class GameFrame extends JFrame implements Runnable, MouseInputListener {

    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000 / TARGET_FPS;

    private boolean running = false;

    private JPanel panel;
    private World world;

    private BufferedImage buffer = null;

    public GameFrame(String name, int width, int height) throws HeadlessException {
        super(name);

        world = new World(width, height);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB );

        Vehicle vehicle = new Vehicle(width/2, height/2, world);
        vehicle.setBehaviour(new AccelerateHorizontalBehaviour(vehicle));
        world.addEntity(vehicle);

/*        Vehicle vehicleSeeker = new Vehicle(width/2, height/2, world);
        vehicleSeeker.setBehaviour(new SeekBehaviour(vehicleSeeker));
        world.addEntity(vehicleSeeker);*/

/*        Vehicle vehicleFlee = new Vehicle(width/2, height/2, world);
        vehicleFlee.setBehaviour(new FleeBehaviour(vehicleFlee));
        world.addEntity(vehicleFlee);*/

/*        Vehicle vehicleArrive = new Vehicle(width/2, height/2, world);
        vehicleArrive.setBehaviour(new ArriveBehaviour(vehicleArrive));
        world.addEntity(vehicleArrive);*/

        Vehicle vehiclePursuit = new Vehicle(width/2, height/2, world);
        vehiclePursuit.setBehaviour(new PursuitBehaviour(vehiclePursuit));
        world.addEntity(vehiclePursuit);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.addMouseListener(this);
        panel.setDoubleBuffered(true);
        add(panel);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void update(float delta) {
        world.update(delta);
    }


    public void render() {
        Graphics g = buffer.getGraphics();
        world.render(g);
        repaint();
    }


    @Override
    public void paint(Graphics g) {
        panel.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void run() {

        long lastUpdateTime = 0;
        running = true;

        while (running) {
            lastUpdateTime = System.currentTimeMillis();

            render();
            update(0.1f);

            try {
                Thread.sleep((lastUpdateTime - System.currentTimeMillis() + OPTIMAL_TIME) / 1000);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            world.setTarget(new Vector2D(e.getX(), e.getY()));
            System.out.println("Immediately after click set Target Position: " + world.getTarget());
/*            System.out.println("Seeker Position: " + position);
            System.out.println("Current Velocity: " + velocity);
            System.out.println("Desired Velocity: " + velocity);*/
        } else if(e.getButton() == MouseEvent.BUTTON3) {
            world.clearTarget();
            world.setTarget(world.getEntityList().get(0).getPosition());
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }
}