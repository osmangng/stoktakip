package com.company;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JFrame;

//login ekranı için kullanılan sınıf. veritabanından değer çekerek isim ve soyisme göre kullanıcı/yönetici
//kararını verip o tipteki sınıftan bir nesne oluştururak tabloya yönlendiriyor. anahtar değişkeni kontrol ediliyor.
public class Giris extends JFrame implements ActionListener{

    JTextField txt1;
    JTextField txt2;
    JButton btn1;
    JLabel lbl1,lbl2,lbl3;
    public int anahtar;

    //private static tanımlamalar gerekli. eğer bunlar olmazsa giriş ile verilen karar sonucu yeni frame açılamaz.
    private static YoneticiTablo yframe;
    private static KullaniciTablo kframe;

    //giriş sınıfının constructoru. frame oluşturuluyor.
    Giris(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        txt1=new JTextField();
        txt1.setBounds(90, 50, 150, 30);
        add(txt1);

        txt2=new JTextField();
        txt2.setBounds(90, 80, 150, 30);
        add(txt2);

        lbl3 = new JLabel("STOK TAKİP PROGRAMI");
        lbl3.setBounds(70, 5, 150, 50);
        add(lbl3);

        lbl1 = new JLabel("İsim");
        lbl1.setBounds(30, 50, 150, 30);
        add(lbl1);

        lbl2 = new JLabel("Soyisim");
        lbl2.setBounds(30, 80, 150, 30);
        add(lbl2);

        btn1=new JButton("Giriş");
        btn1.setBounds(100,120,100,30);
        add(btn1);
        btn1.addActionListener(this);

        setLayout(null);
        setBounds(400, 100, 300, 300);
        setTitle("Giriş Ekranı");
        setResizable(false);
        setVisible(true);

    }

    //tıklama olayları sonucu yapılacaklar. veritabanı bağlantısı sağlanıp alınan değerler ile giriş yapılıyor.
    //veritabanı bağlantıları try-catch blokları içinde yapılmak zorundadır.
    //sorgu için preparedstatement kullanımı zorunludur. kullanıcı girişine göre sorgu yapabilmeyi sağlar.("?" kullanılır)
    public void actionPerformed(ActionEvent e) {
        String a=txt1.getText();
        String b=txt2.getText();
        try{
            String host = "jdbc:mysql://localhost:3306/stoktakip";
            String uName = "root";
            String uPass = "Osman.1533";
            Connection conn = DriverManager.getConnection(host,uName,uPass);
            String sql1=("SELECT * from kullanicilar where isim=? and soyisim=?");
            PreparedStatement st = conn.prepareStatement(sql1);
            st.setString(1,a);
            st.setString(2,b);
            ResultSet rs1= st.executeQuery();
            if(rs1.next()){
                anahtar= rs1.getInt("anahtar");
                if(anahtar==0){
                    dispose();
                    yframe=new YoneticiTablo();
                    yframe.setVisible(true);
                }
                else if(anahtar!=0){
                    dispose();
                    kframe=new KullaniciTablo();
                    kframe.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(btn1, "Hatalı giriş yapıldı.");
            }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
    }

    //ana metot. giriş sınıfından bir frame oluşturuluyor.
    public static void main(String[] args) {
        try{
            Giris frame = new Giris();
        }
        catch(Exception err){
            System.out.println("hata");
        }

    }
}