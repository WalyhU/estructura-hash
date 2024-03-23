package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroVacunas {
    private HashMap<String, Persona> registro;

    public RegistroVacunas() {
        this.registro = new HashMap<>();
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            File file = new File("src/main/resources/vacunas.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String datos = scanner.nextLine();
                String[] partes = datos.split(":", 2);
                String cui = partes[0];
                Persona persona = new Persona(cui);
                JSONArray vacunas = new JSONArray(partes[1]);
                for (int i = 0; i < vacunas.length(); i++) {
                    JSONObject vacuna = vacunas.getJSONObject(i);
                    persona.agregarVacuna(new Vacuna(vacuna.getString("vacuna"), vacuna.getString("fecha")));
                }
                registro.put(cui, persona);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de vacunas");
            throw new RuntimeException(e);
        }
    }

    public Persona obtenerPersona(String cui) {
        return registro.get(cui);
    }
}
