package util;

import model.Socio;
import model.Categoria;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    
    public static void salvarSocios(ArrayList<Socio> socios) {
        try {
            FileOutputStream file = new FileOutputStream("socios.dat");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(socios);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar sócios: " + e.getMessage());
        }
    }
    
    public static ArrayList<Socio> carregarSocios() {
        try {
            FileInputStream file = new FileInputStream("socios.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            ArrayList<Socio> socios = (ArrayList<Socio>) ois.readObject();
            ois.close();
            return socios;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de sócios não encontrado. Criando novo...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar sócios: " + e.getMessage());
        }
        return new ArrayList<Socio>();
    }
    
    public static void salvarCategorias(ArrayList<Categoria> categorias) {
        try {
            FileOutputStream file = new FileOutputStream("categorias.dat");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(categorias);
            oos.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar categorias: " + e.getMessage());
        }
    }
    
    public static ArrayList<Categoria> carregarCategorias() {
        try {
            FileInputStream file = new FileInputStream("categorias.dat");
            ObjectInputStream ois = new ObjectInputStream(file);
            ArrayList<Categoria> categorias = (ArrayList<Categoria>) ois.readObject();
            ois.close();
            return categorias;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de categorias não encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar categorias: " + e.getMessage());
        }
        return new ArrayList<Categoria>();
    }
}