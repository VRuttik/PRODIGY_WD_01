import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {
    JMenuItem home, dashboard, about, contact, logout;

    Home() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 1000);
        add(image);

        JLabel text = new JLabel("");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 10, 1550, 60);
        mb.setBackground(Color.BLACK);
        image.add(mb);

        home = createMenuItem("HOME");
        mb.add(home);

        dashboard = createMenuItem("DASHBOARD");
        mb.add(dashboard);

        about = createMenuItem("ABOUT");
        mb.add(about);

        contact = createMenuItem("CONTACT");
        mb.add(contact);

        logout = createMenuItem("LOGOUT");
        mb.add(logout);

        setVisible(true);
    }

    private JMenuItem createMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setForeground(Color.WHITE);
        menuItem.setBackground(Color.BLACK);
        menuItem.setFont(new Font("Tahoma", Font.PLAIN, 25));
        menuItem.addActionListener(this);
        return menuItem;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == home) {
            disposeAndOpenNewFrame(new Home());
        } else if (ae.getSource() == dashboard) {
            disposeAndOpenNewFrame(new Dashboard());
        } else if (ae.getSource() == about) {
            disposeAndOpenNewFrame(new About(getTitle()));
        } else if (ae.getSource() == contact) {
            disposeAndOpenNewFrame(new Contact());
        } else if (ae.getSource() == logout) {
            disposeAndOpenNewFrame(new InventoryManagementSystem());
        }
    }

    private void disposeAndOpenNewFrame(JFrame newFrame) {
        dispose();
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}

// Dummy classes for Home, Dashboard, About, Contact, InventoryManagementSystem
class Dashboard extends JFrame {
    public Dashboard() { 
        setTitle("Dashboard"); 
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}

class About extends JFrame {
    public About(String title) { 
        setTitle(title); 
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}

class Contact extends JFrame {
    public Contact() { 
        setTitle("Contact"); 
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}

class InventoryManagementSystem extends JFrame {
    public InventoryManagementSystem() { 
        setTitle("Inventory Management System"); 
        setSize(400, 200); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
}

