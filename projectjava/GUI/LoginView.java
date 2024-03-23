/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectjava.VIEW;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author asus
 */
public class LoginView extends JFrame {
 Font TitleFont=new Font("Times New Roman",Font.BOLD,30);
 Font FieldFont=new Font("Times New Roman",Font.PLAIN,16);
 private JComponent[] components;
 
 
 void init()
 {
     

     components=new JComponent[3];
     JPanel container =new JPanel(new GridLayout(3,1));
     ImageIcon backgroundImg=new ImageIcon(getClass().getResource("/img/loginBackground.jpg")); 
      this.setLayout(new FlowLayout());
     JLabel backroundImageLabel=new JLabel(backgroundImg);
    
     JPanel backgroundImagePanel =new JPanel(){
         @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                Image image = backgroundImg.getImage();
                g.drawImage(image, 0, 0, 600, 350, this);
            }
        };
      backgroundImagePanel.setLayout(null);
     
//     JTextField UsernameTextField1=new JTextField("2e234");
//     UsernameTextField1.setBounds(0,0,40,400);
//     UsernameTextField1.setOpaque(true);
//     backgroundImagePanel.add(UsernameTextField1);
    
 
//     this.setLayout(new GridLayout(3,1));
     components[0] = new JLabel("ĐĂNG NHẬP",JLabel.CENTER);
     components[0].setForeground(Color.black);
     components[0].setFont(TitleFont);
    
     components[0].setOpaque(false);
     this.setTitle("LOGIN");
//     this.add(backroundImageLabel);
     
//     JPanel contentPane=new JPanel(new BorderLayout());
//     contentPane.add(backroundImageLabel,BorderLayout.CENTER);
//     this.setContentPane(contentPane);
     
     components[1]=new JPanel(new FlowLayout(FlowLayout.CENTER,100,10));
     
     JTextField UsernameTextField=new JTextField();
     JPasswordField passField=new JPasswordField();

     UsernameTextField.setPreferredSize(new Dimension(250,35));
     passField.setPreferredSize(new Dimension(250,35));
     UsernameTextField.setFont(FieldFont);
     passField.setFont(FieldFont);
     components[1].add(UsernameTextField);
     components[1].add(passField);
     components[1].setOpaque(false);
     
     components[2] = new JPanel(new FlowLayout(FlowLayout.CENTER));
     JLabel LabelButtonLogin = new JLabel("XÁC NHẬN",JLabel.CENTER);
     LabelButtonLogin.setForeground(Color.black);
     
     LabelButtonLogin.setPreferredSize(new Dimension(90 ,40));
  
     LabelButtonLogin.setBackground(Color.white);
     LabelButtonLogin.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
     components[2].add(LabelButtonLogin);
     components[2].setOpaque(false);
     for(JComponent component :  components)
     {
       container.add(component);
     
     }
     
     container.setBounds(0,0,600,350);
     container.setOpaque(false);
     backgroundImagePanel.add(container);
      this.setSize(600,350);
      this.setContentPane(backgroundImagePanel);
    
     
     
     
     
     
     
     
     
     this.setLocationRelativeTo(null);
     this.setResizable(false);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
     
     
 }

 public LoginView()
 {
     init();
 }
    public static void main(String[] args) {
        new LoginView();
    }
}
