package patterns;

import service.SistemaSocios;

public class AutoSaveThread extends Thread {
    private SistemaSocios sistema;
    private boolean executando;
    
    public AutoSaveThread(SistemaSocios sistema) {
        this.sistema = sistema;
        this.executando = true;
        this.setDaemon(true);
    }
    
    @Override 
    public void run() {
        System.out.println("Thread de auto-save iniciada...");
        while (executando) {
            try {
                
                Thread.sleep(30000);
                
                if (executando) {
                    sistema.salvarDados();
                }
                
            } catch (InterruptedException e) {
                System.out.println("Thread de auto-save interrompida");
                break;
            }
        }
        
        System.out.println("Thread de auto-save finalizada");
    }
    
    public void parar() {
        this.executando = false;
        this.interrupt();
    }
}