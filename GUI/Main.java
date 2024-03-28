package qltiemtrasua;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;


public class Main extends JFrame{
    public JLabel lbMenu, lbPhieuNhap, lbPhieuXuat, lbNhanVien, lbKhachHang, lbThongKe,lbTaiKhoan;    JPanel Taskbar, Main;
    JPanel pnCard, pnMenu, pnPhieuNhap, pnPhieuXuat, pnNhanVien, pnKhachHang, pnThongKe,pnTaiKhoan;
    ArrayList<JLabel> ListTaskbar;
    CardLayout cardMenu = new CardLayout();
    Container cn = getContentPane();
    PhieuNhap phieuNhap;
    PhieuXuat phieuXuat;
    NhanVien nhanVien;
    KhachHang khachHang;
    TaiKhoan taiKhoan;
    ThongKe thongKe;
    Menu menu;
    JScrollPane scroll;
    Color MainColor = new Color(250,250,250);
    final Color PanelDefault = new Color(250, 250, 250);//trắng
    final Color PanelHover = new Color(250, 50, 100);//hồng đậm
    final Color PanelClick = new Color(250, 10, 100);//hồng
    
    public Main(){
        initComonent();
    }
    
    void initComonent(){
        this.setSize(new Dimension(1280, 900));
        this.setForeground(MainColor);
        this.setLayout(new BorderLayout(0,0));
        this.setTitle("Cửa hàng Trà Sữa Không Tên");
        Image icon = Toolkit.getDefaultToolkit().getImage("img/TS.png");
        this.setIconImage(icon);
        
        Main = new JPanel();
        Main.setLayout(new BorderLayout());
        
        Taskbar = new JPanel();
        Taskbar.setPreferredSize(new Dimension(225, 200));
        Taskbar.setBackground(Color.pink);
        
        JLabel lbIconUser = new JLabel();
        lbIconUser.setPreferredSize(new Dimension(Taskbar.getPreferredSize().width, 100));
        ImageIcon iconUser = new ImageIcon("img/user.png");
        Image newImage = iconUser.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        lbIconUser.setIcon(new ImageIcon(newImage));
        lbIconUser.setHorizontalAlignment(JLabel.CENTER);
        Taskbar.add(lbIconUser);
        
        JPanel line = new JPanel();
        line.setOpaque(true);
        line.setBackground(new Color(250, 250, 250));
	line.setPreferredSize(new Dimension(150, 2));
	Taskbar.add(line);
        
        JLabel lbTextUser = new JLabel("Quản Lý");
        lbTextUser.setPreferredSize(new Dimension(Taskbar.getPreferredSize().width, 30));
        lbTextUser.setHorizontalAlignment(JLabel.CENTER);
        lbTextUser.setForeground(Color.WHITE);
        Taskbar.add(lbTextUser);
        
        lbMenu = new JLabel("Menu");
        lbPhieuNhap = new JLabel("Phiếu Nhập");
        lbPhieuXuat = new JLabel("Phiếu Xuất");
        lbNhanVien = new JLabel("Nhân Viên");
        lbKhachHang = new JLabel("Khách Hàng");
        lbThongKe = new JLabel("Thống Kê");
        lbTaiKhoan = new JLabel("Tài Khoản");
        
        ListTaskbar = new ArrayList<>();
        ListTaskbar.add(lbMenu);
        ListTaskbar.add(lbPhieuNhap);
        ListTaskbar.add(lbPhieuXuat);
        ListTaskbar.add(lbNhanVien);
        ListTaskbar.add(lbKhachHang);
        ListTaskbar.add(lbTaiKhoan);
        ListTaskbar.add(lbThongKe);

        for (JLabel lb : ListTaskbar){
            lb.setPreferredSize(new Dimension(Taskbar.getPreferredSize().width,50));
            lb.setOpaque(true);
            lb.setForeground(Color.PINK);
            lb.setBackground(MainColor);
            Font font = new Font("Segoe UI",Font.BOLD, 20);
            lb.setFont(font);
            lb.setHorizontalAlignment(JLabel.CENTER);

            Taskbar.add(lb,BorderLayout.CENTER);
        }
        lbMenu.setBackground(PanelClick);
        
        lbMenu.setVisible(true);
        Main.add(Taskbar, BorderLayout.WEST);
        
        pnCard = new JPanel(cardMenu);
        pnMenu = new JPanel();
        pnPhieuNhap = new JPanel();
        pnPhieuXuat = new JPanel();
        pnNhanVien = new JPanel();
        pnKhachHang = new JPanel();
        pnThongKe = new JPanel();
        pnTaiKhoan = new JPanel();
        
        pnCard.add(pnMenu,"1");
        pnCard.add(pnPhieuNhap,"2");
        pnCard.add(pnPhieuXuat,"3");
        pnCard.add(pnNhanVien,"4");
        pnCard.add(pnKhachHang,"5");
        pnCard.add(pnThongKe,"6");
        pnCard.add(pnTaiKhoan,"7");
        
        menu = new Menu();
        pnMenu.setLayout(new BorderLayout());
        pnMenu.add(menu);
        
        phieuNhap = new PhieuNhap();
        pnPhieuNhap.setLayout(new BorderLayout());
        pnPhieuNhap.add(phieuNhap);
        lbPhieuNhap.setVisible(true);
   
        phieuXuat = new PhieuXuat();
        pnPhieuXuat.setLayout(new BorderLayout());
        pnPhieuXuat.add(phieuXuat);
        lbPhieuXuat.setVisible(true);

        nhanVien = new NhanVien();
        pnNhanVien.setLayout(new BorderLayout());
        pnNhanVien.add(nhanVien);
        lbNhanVien.setVisible(true);
        
        khachHang = new KhachHang();
        pnKhachHang.setLayout(new BorderLayout());
        pnKhachHang.add(khachHang);
        lbKhachHang.setVisible(true);
        
        taiKhoan = new TaiKhoan();
        pnTaiKhoan.setLayout(new BorderLayout());
        pnTaiKhoan.add(taiKhoan);
        lbTaiKhoan.setVisible(true);
        
        
        thongKe = new ThongKe();
        pnThongKe.setLayout(new BorderLayout());
        pnThongKe.add(thongKe);
        lbThongKe.setVisible(true);
        
        Main.add(pnCard);
        cn.add(Main);
        
        Mouse();
    }
    private void Mouse(){
        for (JLabel lb : ListTaskbar){
            lb.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (JLabel lbDisable : ListTaskbar) {
                        lbDisable.setBackground(PanelDefault);
                        lb.setForeground(Color.PINK);
                    }
                    lb.setBackground(PanelClick);
                    
                    String cardName = "";
                    if (lb == lbMenu) {
                        cardName = "1";
                    } else if (lb == lbPhieuNhap) {
                        cardName = "2";
                    } else if (lb == lbPhieuXuat) {
                        cardName = "3";
                    } else if (lb == lbNhanVien) {
                        cardName = "4";
                    } else if (lb == lbKhachHang) {
                        cardName = "5";
                    } else if (lb == lbThongKe) {
                        cardName = "6";
                    } else if (lb == lbTaiKhoan) {
                        cardName = "7";
                    }
                    cardMenu.show(pnCard, cardName);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (lb.getBackground().equals(PanelDefault)) {
                        lb.setBackground(PanelHover);
                        lb.setForeground(MainColor);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (lb.getBackground().equals(PanelHover)) {
                        lb.setBackground(PanelDefault);
                        lb.setForeground(Color.PINK);
                    }
                }
            });
        }
    }
    public static void main(String[] args) {
            Main QL = new Main();
            QL.setVisible(true);
        };
}
