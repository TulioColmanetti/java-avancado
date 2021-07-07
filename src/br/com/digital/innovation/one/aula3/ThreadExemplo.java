package br.com.digital.innovation.one.aula3;

public class ThreadExemplo {

    //    IDE shortcut = psvm
    public static void main(String[] args) {
//        Two ways to work with threads in Java

//        1 - Extending class Thread
        GeradorPDF iniciarGeradorPdf = new GeradorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);
//        Using start() method from Thread here will not lock the MAIN thread
        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento.start();

//        2 - Implementing interface Runnable, from which class Thread extends
        BarraDeCarregamento2 testThread = new BarraDeCarregamento2(iniciarGeradorPdf);
//        But not very useful, running the method run() from Runnable here will lock the MAIN thread
//        testThread.run();

//        The MAIN thread will continue to execute, regardless the other threads started
//        This println command will run first than the other threads, showing asynchronous execution
        System.out.println("I am running first");
    }
}

class GeradorPDF extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {
    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {
        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
//                Checks if thread finished
                if (!iniciarGeradorPdf.isAlive()) {
                    break;
                }
                System.out.println("Loading ... ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BarraDeCarregamento2 implements Runnable {
    private Thread th;

    public BarraDeCarregamento2(Thread th) {
        this.th = th;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("Loading2 ..." + th.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

