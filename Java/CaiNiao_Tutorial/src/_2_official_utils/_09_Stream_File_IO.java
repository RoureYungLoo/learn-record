package _2_official_utils;

import java.io.*;

public class _09_Stream_File_IO {
    public static void main(String[] args) throws IOException {
        // testStream();
        // testFileStream();
        // testFileStream2();
        // testDir();
        testDir2();
    }

    public static void testStream() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        /* 读取字符 */
        char c;
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');

        /* 读取字符串 */
        String str;
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("quit"));

        /* 控制台输出 */
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
    }

    /*
    IO流:
        字符流:
            Reader-
                BufferedReader
                InputStreamReader-
                    FileReader
                StringReader
                PipedReader
                CharReader
                FilterReader-
                    PushbackReader
            Writer-
                BufferedWriter
                OutputStreamWriter-
                    FileWriter
                PrinterWriter
                StringWriter
                PipedWriter
                CharArrayWriter
                FilterWriter
        字节流:
            InputStream-
                FileInputStream
                FilterInputStream-
                    BufferedInputStream
                    DataInputStream
                    PushbackInputStream
                ObjectInputStream
                PipedInputStream
                SequenceInputStream
                StringBufferInputStream
                ByteArrayInputStream
            OutputStream
                FileOutputStream
                FilterOutputStream-
                    BufferedOutputStream
                    DataOutputStream
                    PrintStream
                ObjectOutputStream
                PipedOutputStream
                ByteArrayOutputStream
    */
    public static void testIO() {

    }

    public static void testFileInputStream() throws IOException {
        String fname = "C:\\Users\\RuoYang\\Desktop\\FileInputStream.txt";
        InputStream f = new FileInputStream(fname);

        File file = new File(fname);
        InputStream is = new FileInputStream(file);
    }

    public static void testFileOutputStream() throws IOException {
        String fname = "C:\\Users\\RuoYang\\Desktop\\FileOutputStream.txt";
        OutputStream f = new FileOutputStream(fname);

        File file = new File(fname);
        OutputStream out = new FileOutputStream(file);
    }

    public static void testFileStream() throws IOException {
        String fname = "C:\\Users\\RuoYang\\Desktop\\Stream.txt";

        byte[] array = {11, 21, 3, 40, 5};
        OutputStream out = new FileOutputStream(fname);
        for (int i = 0; i < array.length; i++) {
            out.write(array[i]);
        }
        out.close();

        InputStream in = new FileInputStream(fname);
        int size = in.available();
        for (int i = 0; i < size; i++) {
//            System.out.print((char) in.read() + " ");
            System.out.print(in.read() + " ");
        }
        in.close();
    }

    public static void testFileStream2() throws IOException {
        String fname = "C:\\Users\\RuoYang\\Desktop\\Stream.txt";

        byte[] array = {11, 21, 3, 40, 5};
        FileOutputStream fout = new FileOutputStream(fname);
        OutputStreamWriter writer = new OutputStreamWriter(fout, "UTF-8");
        for (int i = 0; i < array.length; i++) {
            writer.append((char) array[i]);
            // writer.append("(char) array[i]");
        }
        writer.close();
        fout.close();

        FileInputStream fis = new FileInputStream(fname);
        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            // sb.append((char) reader.read());
            sb.append(reader.read() + " ");
        }
        System.out.println(sb.toString());
        reader.close();
        fis.close();

    }

    public static void testDir() {
        String dirname = "C:\\Users\\RuoYang\\Desktop\\testDir\\1\\2\\3";
        File dir = new File(dirname);

        /* 创建目录 */
        // dir.mkdir();
        dir.mkdirs();

        /* 读取目录 */
        String filename = "C:\\Users\\RuoYang\\Desktop";
        File file = new File(filename);
        if (file.isDirectory()) {
            System.out.println("目录：" + filename);
            String[] entries = file.list();
            for (int i = 0; i < entries.length; i++) {
                String entry = filename + "/" + entries[i];
                File tmp = new File(entry);
                if (tmp.isDirectory()) {
                    System.out.println(entry + "是目录");
                }
                if (tmp.isFile()) {
                    System.out.println(entry + "是文件");
                }
            }
        } else {
            System.out.println("文件：" + filename);
        }
    }

    public static void testDir2() {
        /* 删除目录或文件 */
        String dirname2 = "C:\\Users\\RuoYang\\Desktop\\testDir";
        File dir2 = new File(dirname2);
        testDeleteDir(dir2);
    }

    public static void testDeleteDir(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println("--");
                if (f.isDirectory()) {
                    System.out.println("--1: " + f.getAbsolutePath());
                    testDeleteDir(f);
                } else {
                    System.out.println("--2");
                    boolean b = f.delete();
                    if (b) {

                        System.out.println("已删除：" + f.getName());
                    } else {
                        System.out.println("删除失败：" + f.getName());
                    }
                }

            }
        }
        System.out.println("删除空目录：" + folder.getAbsolutePath());
        folder.delete();

    }
}
