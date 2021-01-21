package com.company;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import com.mysql.cj.protocol.Resultset;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//jframe sınıfını kalıtan ve actionlistener interface'sini kullanan kullanicitablo sınıfı.
//actionlistener interface'sinin kullanılabilmesi için actionperformed metodu kullanılmalıdır.
public class KullaniciTablo extends JFrame implements ActionListener{
    JPanel panel1;
    JTable tablo;
    JScrollPane jsn1;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    JTextField txt1;
    JLabel lbl1,lbl2;

    //kullanicitablo constructoru. frame oluşturuluyor.
    //tüm işlemler tek frame üzerinden yürütülecek. basit bir tasarım.
    KullaniciTablo(){

        panel1 = new JPanel(null);
        setSize(500, 500);
        tablo=new JTable();

        lbl1=new JLabel("Kullanıcı İşlemleri");
        lbl1.setBounds(400,0,100,20);
        add(lbl1);

        btn1=new JButton("Çıkış");
        btn1.setBounds(475,340,100,30);
        add(btn1);
        btn1.addActionListener(this);

        btn2=new JButton("Stok-artan");
        btn2.setBounds(350,20,100,30);
        add(btn2);
        btn2.addActionListener(this);

        btn3=new JButton("Stok-azalan");
        btn3.setBounds(455,20,100,30);
        add(btn3);
        btn3.addActionListener(this);

        btn4=new JButton("Fiyat-artan");
        btn4.setBounds(350,55,100,30);
        add(btn4);
        btn4.addActionListener(this);

        btn5=new JButton("Fiyat-azalan");
        btn5.setBounds(455,55,100,30);
        add(btn5);
        btn5.addActionListener(this);

        btn6=new JButton("Id-artan");
        btn6.setBounds(350,90,100,30);
        add(btn6);
        btn6.addActionListener(this);

        btn7=new JButton("Id-azalan");
        btn7.setBounds(455,90,100,30);
        add(btn7);
        btn7.addActionListener(this);

        btn8=new JButton("İşlemci");
        btn8.setBounds(350,125,100,30);
        add(btn8);
        btn8.addActionListener(this);

        btn9=new JButton("Ekran kartı");
        btn9.setBounds(455,125,100,30);
        add(btn9);
        btn9.addActionListener(this);

        btn10=new JButton("Arama yap");
        btn10.setBounds(455,160,100,30);
        add(btn10);
        btn10.addActionListener(this);

        txt1=new JTextField("İsim girin");
        txt1.setBounds(350,160,100,30);
        add(txt1);
        txt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txt1.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        try{
            String host = "jdbc:mysql://localhost:3306/stoktakip";
            String uName = "root";
            String uPass = "Osman.1533";
            Connection conn = DriverManager.getConnection(host,uName,uPass);
            PreparedStatement ps = conn.prepareStatement("Select * from urunler");
            ResultSet rs=ps.executeQuery();
            String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
            tablo.setModel(tableModel);
            while(rs.next()){
                String id1 = rs.getString("id");
                String isim1 = rs.getString("isim");
                String fiyat1 = rs.getString("fiyat");
                String tur1 = rs.getString("tur");
                String stok1 = rs.getString("stok");
                String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                tableModel.addRow(data);
            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hata oluştu."+e);
        }

        jsn1 = new JScrollPane(tablo);            // add table to scroll panel
        jsn1.setBounds(5, 10, 300, 150);
        setTitle("Kullanıcı Ekranı");
        setBounds(400, 100, 700, 600);
        jsn1.setVisible(true);
        panel1.add(jsn1);
        this.add(panel1);

        //giriş başarılıysa, mesaj yazdırılır.
        JOptionPane.showMessageDialog(null, "Kullanıcı girişi başarılı.");
    }

    public void actionPerformed(ActionEvent e) {

        String giris1 = (txt1.getText());

        if (e.getSource().equals(btn1)) {
            dispose();
        }

        if (e.getSource().equals(btn2)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by stok asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn3)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by stok desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn4)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by fiyat asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn5)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by fiyat desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn6)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by id asc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn7)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler order by id desc");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }
        if (e.getSource().equals(btn8)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where tur='islemci'");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn9)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where tur='ekran karti'");
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

        if (e.getSource().equals(btn10)) {
            try{
                String host = "jdbc:mysql://localhost:3306/stoktakip";
                String uName = "root";
                String uPass = "Osman.1533";
                Connection conn = DriverManager.getConnection(host,uName,uPass);
                PreparedStatement ps = conn.prepareStatement("Select * from urunler where isim=?");
                ps.setString(1,giris1);
                ResultSet rs=ps.executeQuery();
                String[] columnNames = {"id", "isim", "fiyat", "tur", "stok"};
                DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
                tablo.setModel(tableModel);
                while(rs.next()){
                    String id1 = rs.getString("id");
                    String isim1 = rs.getString("isim");
                    String fiyat1 = rs.getString("fiyat");
                    String tur1 = rs.getString("tur");
                    String stok1 = rs.getString("stok");
                    String[] data = { id1, isim1, fiyat1, tur1, stok1 } ;
                    tableModel.addRow(data);
                }

            }
            catch(Exception es){
                JOptionPane.showMessageDialog(null,"Hata oluştu."+es);
            }
        }

    }
}