import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.table.DefaultTableModel;

public class ManajemenPeternakanGUI extends JFrame {
    private SistemManajemenPeternakan sistem;

    public ManajemenPeternakanGUI() {
        sistem = new SistemManajemenPeternakan();
        inisialisasiGUI();
    }

    private void inisialisasiGUI() {
        setTitle("Sistem Manajemen Peternakan Modern");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane panelTab = new JTabbedPane();
        panelTab.addTab("Hewan", buatPanelHewan());
        panelTab.addTab("Pakan", buatPanelPakan());
        panelTab.addTab("Pekerja", buatPanelPekerja());
        panelTab.addTab("Produksi", buatPanelProduksi(sistem));
        panelTab.addTab("Kesehatan", buatPanelPemeriksaan(sistem));
        panelTab.addTab("Supplier", buatPanelSupplier());
        panelTab.addTab("Jadwal Kerja", buatPanelJadwal());
        panelTab.addTab("Kandang", buatPanelKandang());
        add(panelTab);
    }

    private JPanel buatPanelHewan() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel modelHewan = new DefaultTableModel();
        modelHewan.addColumn("ID");
        modelHewan.addColumn("Jenis");
        modelHewan.addColumn("Umur");
        modelHewan.addColumn("Berat");
        modelHewan.addColumn("Status Kesehatan");
    
        JTable tabelHewan = new JTable(modelHewan);
        JScrollPane scrollPane = new JScrollPane(tabelHewan);
    
        JButton tombolTambah = new JButton("Tambah Hewan");
        tombolTambah.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Masukkan ID Hewan:");
            String[] jenis = {"Sapi", "Kambing", "Ayam"};
            JComboBox<String> comboBoxJenis = new JComboBox<>(jenis);
            int option = JOptionPane.showConfirmDialog(null,comboBoxJenis,"Pilih Jenis Hewan:",
                JOptionPane.OK_CANCEL_OPTION);
            if (option != JOptionPane.OK_OPTION)
                return;
                String jenisHewan = (String) comboBoxJenis.getSelectedItem();

            int umur = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Umur Hewan:"));
            double berat = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Berat Hewan:"));
            String status = JOptionPane.showInputDialog("Masukkan Status Kesehatan:");
    
            Hewan hewan = new Hewan(id, jenisHewan, umur, berat, status);
    
            sistem.tambahHewan(hewan);
    
            modelHewan.addRow(new Object[]{ hewan.getId(), hewan.getJenis(), hewan.getUmur(), hewan.getBerat(), hewan.getStatusKesehatan()});

            simpanHewanKeFile(hewan);
    
            hewan.displayInfo();
        });
    
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private void simpanHewanKeFile(Hewan hewan) {
        File file = new File("Hewan.txt");
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String data = hewan.getId() + " | " + hewan.getStatusKesehatan() + " | " + hewan.getDiagnosa() + " | " + hewan.getTanggalPemeriksaan();
            writer.write(data);
            writer.newLine();
    
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }

    private JPanel buatPanelPakan() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel modelPakan = new DefaultTableModel();
        modelPakan.addColumn("Jenis");
        modelPakan.addColumn("Jumlah");
        modelPakan.addColumn("Tanggal Kadaluarsa");
        modelPakan.addColumn("ID Supplier");

        JTable tabelPakan = new JTable(modelPakan);
        JScrollPane scrollPane = new JScrollPane(tabelPakan);

        JButton tombolTambah = new JButton("Tambah Pakan");
        tombolTambah.addActionListener(e -> {
            String jenis = JOptionPane.showInputDialog("Masukkan Jenis Pakan:");
            double jumlah = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Jumlah Pakan:"));
            String tanggal = JOptionPane.showInputDialog("Masukkan Tanggal Kadaluarsa:");
            String idSupplier = JOptionPane.showInputDialog("Masukkan ID Supplier:");

            sistem.tambahPakan(new Pakan(jenis, jumlah, tanggal, idSupplier));
            modelPakan.addRow(new Object[]{jenis, jumlah, tanggal, idSupplier});
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buatPanelPekerja() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel modelPekerja = new DefaultTableModel();
        modelPekerja.addColumn("ID");
        modelPekerja.addColumn("Nama");
        modelPekerja.addColumn("Tugas Harian");
        modelPekerja.addColumn("Kontak");

        JTable tabelPekerja = new JTable(modelPekerja);
        JScrollPane scrollPane = new JScrollPane(tabelPekerja);

        JButton tombolTambah = new JButton("Tambah Pekerja");
        tombolTambah.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Masukkan ID Pekerja:");
            String nama = JOptionPane.showInputDialog("Masukkan Nama:");
            String tugas = JOptionPane.showInputDialog("Masukkan Tugas Harian:");
            String kontak = JOptionPane.showInputDialog("Masukkan Kontak:");

            sistem.tambahPekerja(new Pekerja(id, nama, tugas, kontak));
            modelPekerja.addRow(new Object[]{id, nama, tugas, kontak});
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buatPanelProduksi(SistemManajemenPeternakan sistem) {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel modelProduksi = new DefaultTableModel();
        modelProduksi.addColumn("ID Hewan");
        modelProduksi.addColumn("Jenis Produk");
        modelProduksi.addColumn("Jumlah");
        modelProduksi.addColumn("Tanggal");
    
        JTable tabelProduksi = new JTable(modelProduksi);
        JScrollPane scrollPane = new JScrollPane(tabelProduksi);
    
        JButton tombolTambah = new JButton("Tambah Produksi");
        tombolTambah.addActionListener(e -> {
            try {
                String idHewan = JOptionPane.showInputDialog("Masukkan ID Hewan:");
                String jenisProduk = JOptionPane.showInputDialog("Masukkan Jenis Produk:");
                double jumlah = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Jumlah Produksi:"));
                String tanggal = JOptionPane.showInputDialog("Masukkan Tanggal Produksi:");
    
                sistem.catatProduksi(idHewan, jenisProduk, jumlah, tanggal);
    
                for (LaporanProduksi laporan : sistem.getProduksiList()) {
                    if (laporan.getId().equals(idHewan)) {
                        modelProduksi.addRow(new Object[]{
                            laporan.getId(),
                            laporan.getJenisProduk(),
                            laporan.getJumlah(),
                            laporan.getTanggal()
                        });

                        simpanProduksiKeFile(laporan);
    
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(panel, "Masukkan jumlah dalam format angka!", "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }
    
    private void simpanProduksiKeFile(LaporanProduksi laporan) {
        File file = new File("produksi.txt");
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String data = laporan.getId() + " | " + laporan.getJenisProduk() + " | " + laporan.getJumlah() + " | " + laporan.getTanggal();
    
            writer.write(data);
            writer.newLine();
    
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    

    private JPanel buatPanelPemeriksaan(SistemManajemenPeternakan sistem) {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel modelPemeriksaan = new DefaultTableModel();
        modelPemeriksaan.addColumn("ID Hewan");
        modelPemeriksaan.addColumn("Status Kesehatan");
        modelPemeriksaan.addColumn("Diagnosa");
        modelPemeriksaan.addColumn("Tanggal Pemeriksaan");
    
        JTable tabelPemeriksaan = new JTable(modelPemeriksaan);
        JScrollPane scrollPane = new JScrollPane(tabelPemeriksaan);
    
        JButton tombolTambah = new JButton("Tambah Pemeriksaan");
        tombolTambah.addActionListener(e -> {
            try {
                String idHewan = JOptionPane.showInputDialog("Masukkan ID Hewan:");
                Hewan hewan = sistem.cariHewan(idHewan);
                if (hewan != null) {
                    String statusKesehatan = JOptionPane.showInputDialog("Masukkan Status Kesehatan:");
                    String diagnosa = JOptionPane.showInputDialog("Masukkan Diagnosa:");
                    String tanggal = JOptionPane.showInputDialog("Masukkan Tanggal Pemeriksaan:");
    
                    hewan.lakukanPemeriksaan(statusKesehatan, diagnosa, tanggal);
                    sistem.tambahPemeriksaan(hewan);
    
                    modelPemeriksaan.addRow(new Object[]{
                        hewan.getId(),
                        hewan.getStatusKesehatan(),
                        hewan.getDiagnosa(),
                        hewan.getTanggalPemeriksaan()
                    });

                    simpanPemeriksaanKeFile(hewan);

                    JOptionPane.showMessageDialog(panel, "Pemeriksaan berhasil ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(panel, "Hewan dengan ID " + idHewan + " tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private void simpanPemeriksaanKeFile(Hewan hewan) {
    File file = new File("pemeriksaan.txt");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
        String data = hewan.getId() + " | " + hewan.getStatusKesehatan() + " | " + hewan.getDiagnosa() + " | " + hewan.getTanggalPemeriksaan();

        writer.write(data);
        writer.newLine();

    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data ke file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private JPanel buatPanelSupplier() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Supplier");
        model.addColumn("Jenis Pakan");
        model.addColumn("No HP");

        JTable tabel = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabel);
        JButton tombolTambah = new JButton("Tambah Supplier");

        tombolTambah.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Masukkan ID Supplier:");
            String jenis = JOptionPane.showInputDialog("Masukkan Jenis Pakan:");
            String noHp = JOptionPane.showInputDialog("Masukkan No HP:");

            sistem.tambahSupplier(new Supplier(id, jenis, noHp));
            model.addRow(new Object[]{id, jenis, noHp});
            JOptionPane.showMessageDialog(null, "Supplier berhasil ditambahkan!");
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buatPanelJadwal() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Jadwal");
        model.addColumn("ID Pekerja");
        model.addColumn("Waktu Kerja");

        JTable tabel = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabel);
        JButton tombolTambah = new JButton("Tambah Jadwal");

        tombolTambah.addActionListener(e -> {
            String idJadwal = JOptionPane.showInputDialog("Masukkan ID Jadwal:");
            String idPekerja = JOptionPane.showInputDialog("Masukkan ID Pekerja:");
            String waktuKerja = JOptionPane.showInputDialog("Masukkan Waktu Kerja:");

            sistem.tambahJadwal(new JadwalKerja(idJadwal, idPekerja, waktuKerja));
            model.addRow(new Object[]{idJadwal, idPekerja, waktuKerja});
            JOptionPane.showMessageDialog(null, "Jadwal berhasil ditambahkan!");
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel buatPanelKandang() {
        JPanel panel = new JPanel(new BorderLayout());
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Hewan");
        model.addColumn("Jumlah Hewan");
        model.addColumn("Lokasi");

        JTable tabel = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabel);
        JButton tombolTambah = new JButton("Tambah Kandang");

        tombolTambah.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Masukkan ID Hewan:");
            String kapasitasInput = JOptionPane.showInputDialog("Masukkan Kapasitas:");
            int jumlah = Integer.parseInt(kapasitasInput);
            String lokasi = JOptionPane.showInputDialog("Masukkan Lokasi:");

            sistem.tambahKandang(new Kandang(id, jumlah, lokasi));
            model.addRow(new Object[]{id, jumlah, lokasi});
            JOptionPane.showMessageDialog(null, "Kandang berhasil ditambahkan!");
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(tombolTambah, BorderLayout.SOUTH);
        return panel;
    }

    public void gantiPanel(JPanel panelBaru) {
        this.getContentPane().removeAll();
        this.getContentPane().add(panelBaru);
        this.revalidate();
        this.repaint();
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManajemenPeternakanGUI gui = new ManajemenPeternakanGUI();
            gui.setVisible(true);
        });
    }
}