
package FinalProjectMongoDB;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class TrainTicketSystem {

    // Creacion de las variables para las entidades

    // usuarios
    static int id;
    static String nombre;
    static String apellido;
    static String origen;
    static String destino;

    // usuario cajero
    static String rol;
    static String password;

    // tren
    static int trenId;
    static String modelo;
    static int capacidad;

    // ticket
    static int ticketId;
    static int usuario;
    static String origenRuta;
    static String destinoRuta;
    static String silla;
    static int tren;
    static String fecha;
    static String hora;
    static double precio;

    // venta
    static int ventaId;
    static int ticketIdVenta;
    static int cantidad;
    static double precioVentaUnitario;
    static double totalVenta;


    public static void main(String[] args) {

        ConexionMongoDB.conectar();

        registrarCajero();

        if (iniciarsesion()) {

            String trainTicket = "no";

            while (trainTicket.equals("no")) {

                System.out.println("=======FERROCARRILES DE ANTIOQUIA======= \n" +
                        "1.Gestion de usuarios \n" +
                        "2.Gestion de Trenes \n" +
                        "3.Gestion de tickets \n" +
                        "4.Gestion de ventas \n" +
                        "5.Gestion de cajeros \n" +
                        "6.Salir");

                int opcion = ValidadorDeTipo.ValidarEnteros();

                switch (opcion) {

                    case 1: {

                        int opcionUsuario = 0;

                        while (opcionUsuario != 6) {

                            System.out.println("\n=====Gestion de usuarios=====");
                            System.out.println("1. Crear usuario");
                            System.out.println("2. Actualizar usuario");
                            System.out.println("3. Consultar todos los usuarios");
                            System.out.println("4. Consultar usuario por ID");
                            System.out.println("5. Eliminar usuario");
                            System.out.println("6. Volver al menu principal");

                            opcionUsuario = ValidadorDeTipo.ValidarEnteros();

                            switch (opcionUsuario) {

                                case 1:
                                    crearUsuario();
                                    break;

                                case 2:
                                    actualizarDatos();
                                    break;

                                case 3:
                                    consultarUsuario();
                                    break;

                                case 4:
                                    consultarUsuarioPorId();
                                    break;

                                case 5:
                                    eliminarUsuario();
                                    break;

                                case 6:
                                    System.out.println("Regresar al menu principal");
                                    break;

                                default:
                                    System.out.println("Opcion no valida.");
                                    break;
                            }
                        }
                        break;
                    }

                    case 2: {

                        int opcionTrenes = 0;

                        while (opcionTrenes != 6) {

                            System.out.println("\n=====Gestion de trenes=====");
                            System.out.println("1. Crear tren");
                            System.out.println("2. Actualizar tren");
                            System.out.println("3. Consultar todos los trenes");
                            System.out.println("4. Consultar tren por ID");
                            System.out.println("5. Eliminar tren");
                            System.out.println("6. Volver al menu principal");

                            opcionTrenes = ValidadorDeTipo.ValidarEnteros();

                            switch (opcionTrenes) {

                                case 1:
                                    crearTren();
                                    break;

                                case 2:
                                    actualizarTren();
                                    break;

                                case 3:
                                    consultarTrenes();
                                    break;

                                case 4:
                                    consultarTrenPorId();
                                    break;

                                case 5:
                                    eliminarTren();
                                    break;

                                case 6:
                                    System.out.println("Regresar al menu principal");
                                    break;

                                default:
                                    System.out.println("Opcion no valida.");
                                    break;
                            }
                        }
                        break;
                    }

                    case 3: {

                        int opcionTicket = 0;

                        while (opcionTicket != 6) {

                            System.out.println("\n=====Gestion de tickets=====");
                            System.out.println("1. Crear ticket");
                            System.out.println("2. Actualizar ticket");
                            System.out.println("3. Consultar todos los tickets");
                            System.out.println("4. Consultar ticket por ID");
                            System.out.println("5. Eliminar ticket");
                            System.out.println("6. Volver al menu principal");

                            opcionTicket = ValidadorDeTipo.ValidarEnteros();

                            switch (opcionTicket) {

                                case 1:
                                    crearTicket();
                                    break;

                                case 2:
                                    actualizarTicket();
                                    break;

                                case 3:
                                    consultarTicket();
                                    break;

                                case 4:
                                    consultarTicketPorId();
                                    break;

                                case 5:
                                    eliminarTicket();
                                    break;

                                case 6:
                                    System.out.println("Regresar al menu principal");
                                    break;

                                default:
                                    System.out.println("Opcion no valida.");
                                    break;
                            }
                        }
                        break;
                    }

                    case 4: {

                        int opcionVentas = 0;

                        while (opcionVentas != 6) {

                            System.out.println("\n=====Gestion de ventas=====");
                            System.out.println("1. Crear venta");
                            System.out.println("2. Actualizar venta");
                            System.out.println("3. Consultar todas las ventas");
                            System.out.println("4. Consultar ventas por ID");
                            System.out.println("5. Eliminar venta");
                            System.out.println("6. Volver al menu principal");

                            opcionVentas = ValidadorDeTipo.ValidarEnteros();

                            switch (opcionVentas) {

                                case 1:
                                    crearVenta();
                                    break;

                                case 2:
                                    actualizarVentas();
                                    break;

                                case 3:
                                    consultarVentas();
                                    break;

                                case 4:
                                    consultarVentasPorId();
                                    break;

                                case 5:
                                    eliminarVenta();
                                    break;

                                case 6:
                                    System.out.println("Regresar al menu principal");
                                    break;

                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }
                        }
                        break;
                    }

                    case 5: {

                        int opcionCajero = 0;

                        while (opcionCajero != 6) {

                            System.out.println("\n=====Gestion de cajeros=====");
                            System.out.println("1. Crear cajero");
                            System.out.println("2. Actualizar cajero");
                            System.out.println("3. Consultar cajero");
                            System.out.println("4. Eliminar cajero");
                            System.out.println("6. Volver al menu principal");

                            opcionCajero = ValidadorDeTipo.ValidarEnteros();

                            switch (opcionCajero) {

                                case 1:
                                    registrarCajero();
                                    break;

                                case 2:
                                    actualizarCajero();
                                    break;

                                case 3:
                                    consultarCajero();
                                    break;

                                case 4:
                                    eliminarCajero();
                                    break;

                                case 6:
                                    System.out.println("Regresar al menu principal");
                                    break;

                                default:
                                    System.out.println("Opcion no valida.");
                                    break;
                            }
                        }
                        break;
                    }

                    case 6:
                        trainTicket = "si";
                        System.out.println("Gracias por usar el sistema");
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }


    // =========================================
    // ARRAY Y MATRICES DE USUARIOS
    // =========================================

    static String[][] usuarios = new String[3][5];

    static String[] encabezados = {
            "id", "nombre", "apellido", "origen", "destino"
    };


    public static void crearUsuario() {

        MongoCollection<Document> usuariosMongo =
                ConexionMongoDB.conectar().getCollection("usuarios");

        for (int i = 0; i < encabezados.length; i++) {
            System.out.println(encabezados[i]);
        }

        for (int i = 0; i < usuarios.length; i++) {

            for (int j = 0; j < usuarios[i].length; j++) {

                System.out.println("Ingrese dato " + encabezados[j] + ": ");
                usuarios[i][j] = ValidadorDeTipo.ValidarString();
            }

            Document filtro = new Document("id", usuarios[i][0]);

            Document usuarioRegistrado = usuariosMongo.find(filtro).first();

            Document nuevoUsuario = new Document("id", usuarios[i][0])
                    .append("nombre", usuarios[i][1])
                    .append("apellido", usuarios[i][2])
                    .append("origen", usuarios[i][3])
                    .append("destino", usuarios[i][4]);

            if (usuarioRegistrado == null) {

                usuariosMongo.insertOne(nuevoUsuario);

                System.out.println("Usuario registrado correctamente.");

            } else {

                usuariosMongo.replaceOne(filtro, nuevoUsuario);

                System.out.println("El usuario ya existia y fue reemplazado.");
            }
        }
    }


    public static void consultarUsuario() {

        MongoCollection<Document> usuariosMongo =
                ConexionMongoDB.conectar().getCollection("usuarios");

        Document usuarioRegistrado = usuariosMongo.find().first();

        if (usuarioRegistrado != null) {

            usuarios[1][0] = usuarioRegistrado.getString("id");
            usuarios[0][1] = usuarioRegistrado.getString("nombre");
            usuarios[0][2] = usuarioRegistrado.getString("apellido");
            usuarios[0][3] = usuarioRegistrado.getString("origen");
            usuarios[0][4] = usuarioRegistrado.getString("destino");

            for (int i = 0; i < encabezados.length; i++) {
                System.out.print(encabezados[i] + "\t");
            }

            System.out.println();

            for (int i = 0; i < usuarios.length; i++) {

                for (int j = 0; j < usuarios[i].length; j++) {
                    System.out.print(usuarios[i][j] + "\t");
                }

                System.out.println();
            }

        } else {

            System.out.println("No hay usuarios registrados.");
        }
    }


    public static void consultarUsuarioPorId() {

        MongoCollection<Document> usuariosMongo =
                ConexionMongoDB.conectar().getCollection("usuarios");

        System.out.println("Ingrese el ID del usuario: ");
        String idBuscar = ValidadorDeTipo.ValidarString();

        Document usuarioRegistrado =
                usuariosMongo.find(new Document("id", idBuscar)).first();

        if (usuarioRegistrado != null) {

            for (int j = 0; j < encabezados.length; j++) {

                System.out.println(
                        encabezados[j] + ": " +
                                usuarioRegistrado.getString(encabezados[j])
                );
            }

        } else {

            System.out.println("Usuario no encontrado.");
        }
    }


    public static void actualizarDatos() {

        MongoCollection<Document> usuariosMongo =
                ConexionMongoDB.conectar().getCollection("usuarios");

        System.out.print("Ingrese el ID del usuario que desea actualizar: ");
        String idBuscar = ValidadorDeTipo.ValidarString();

        Document usuarioRegistrado =
                usuariosMongo.find(new Document("id", idBuscar)).first();

        if (usuarioRegistrado != null) {

            usuarios[0][0] = usuarioRegistrado.getString("id");
            usuarios[0][1] = usuarioRegistrado.getString("nombre");
            usuarios[0][2] = usuarioRegistrado.getString("apellido");
            usuarios[0][3] = usuarioRegistrado.getString("origen");
            usuarios[0][4] = usuarioRegistrado.getString("destino");

            for (int j = 1; j < usuarios[0].length; j++) {

                System.out.print("Ingrese nuevo " + encabezados[j] + ": ");
                usuarios[0][j] = ValidadorDeTipo.ValidarString();
            }

            Document nuevosDatos = new Document("id", usuarios[0][0])
                    .append("nombre", usuarios[0][1])
                    .append("apellido", usuarios[0][2])
                    .append("origen", usuarios[0][3])
                    .append("destino", usuarios[0][4]);

            UpdateResult resultado = usuariosMongo.replaceOne(
                    new Document("id", idBuscar),
                    nuevosDatos
            );

            if (resultado.getMatchedCount() > 0) {

                if (resultado.getModifiedCount() > 0) {
                    System.out.println("Usuario actualizado correctamente.");
                } else {
                    System.out.println("El usuario ya tenia esos mismos datos.");
                }

            } else {

                System.out.println("MongoDB no encontro el usuario para actualizar.");
            }

        } else {

            System.out.println("Usuario no encontrado.");
        }
    }


    public static void eliminarUsuario() {

        MongoCollection<Document> usuariosMongo =
                ConexionMongoDB.conectar().getCollection("usuarios");

        System.out.println("Ingrese el ID del usuario que desea eliminar: ");
        String idEliminar = ValidadorDeTipo.ValidarString();

        Document resultado = usuariosMongo.find(
                new Document("id", idEliminar)
        ).first();

        if (resultado != null) {

            usuariosMongo.deleteOne(new Document("id", idEliminar));

            if (usuarios[0][0] != null && usuarios[0][0].equals(idEliminar)) {

                for (int j = 0; j < usuarios[0].length; j++) {
                    usuarios[0][j] = null;
                }
            }

            System.out.println("Usuario eliminado correctamente.");

        } else {

            System.out.println("Usuario no encontrado.");
        }
    }



    // ARRAY Y MATRICES DE TRENES


    static String[][] trenes = new String[2][3];

    static String[] encabezadosTren = {
            "id", "modelo", "capacidad"
    };


    static public void crearTren() {

        MongoCollection<Document> trenesMongo =
                ConexionMongoDB.conectar().getCollection("trenes");

        for (int i = 0; i < encabezadosTren.length; i++) {
            System.out.println(encabezadosTren[i]);
        }

        for (int i = 0; i < trenes.length; i++) {

            for (int j = 0; j < trenes[i].length; j++) {

                System.out.println("Ingrese dato del tren " + encabezadosTren[j] + ": ");
                trenes[i][j] = ValidadorDeTipo.ValidarString();
            }

            Document filtro = new Document("id", trenes[i][0]);

            Document trenRegistrado = trenesMongo.find(filtro).first();

            Document nuevoTren = new Document("id", trenes[i][0])
                    .append("modelo", trenes[i][1])
                    .append("capacidad", trenes[i][2]);

            if (trenRegistrado == null) {

                trenesMongo.insertOne(nuevoTren);

                System.out.println("Tren registrado correctamente.");

            } else {

                trenesMongo.replaceOne(filtro, nuevoTren);

                System.out.println("El tren ya existia y fue reemplazado.");
            }
        }
    }


    static public void consultarTrenes() {

        MongoCollection<Document> trenesMongo =
                ConexionMongoDB.conectar().getCollection("trenes");

        Document trenRegistrado = trenesMongo.find().first();

        if (trenRegistrado != null) {

            trenes[0][0] = trenRegistrado.getString("id");
            trenes[0][1] = trenRegistrado.getString("modelo");
            trenes[0][2] = trenRegistrado.getString("capacidad");

            for (int i = 0; i < encabezadosTren.length; i++) {
                System.out.print(encabezadosTren[i] + "\t");
            }

            System.out.println();

            for (int i = 0; i < trenes.length; i++) {

                for (int j = 0; j < trenes[i].length; j++) {
                    System.out.print(trenes[i][j] + "\t");
                }

                System.out.println();
            }

        } else {

            System.out.println("No hay trenes registrados.");
        }
    }


    static public void consultarTrenPorId() {

        MongoCollection<Document> trenesMongo =
                ConexionMongoDB.conectar().getCollection("trenes");

        System.out.println("Ingrese el ID del tren: ");
        String idBuscarTren = ValidadorDeTipo.ValidarString();

        Document trenRegistrado =
                trenesMongo.find(new Document("id", idBuscarTren)).first();

        if (trenRegistrado != null) {

            for (int j = 0; j < encabezadosTren.length; j++) {

                System.out.println(
                        encabezadosTren[j] + ": " +
                                trenRegistrado.getString(encabezadosTren[j])
                );
            }

        } else {

            System.out.println("Tren no encontrado.");
        }
    }


    static public void actualizarTren() {

        MongoCollection<Document> trenesMongo =
                ConexionMongoDB.conectar().getCollection("trenes");

        System.out.println("Ingrese el ID del tren que desea actualizar: ");
        String idBuscarTren = ValidadorDeTipo.ValidarString();

        Document trenRegistrado =
                trenesMongo.find(new Document("id", idBuscarTren)).first();

        if (trenRegistrado != null) {

            trenes[0][0] = trenRegistrado.getString("id");
            trenes[0][1] = trenRegistrado.getString("modelo");
            trenes[0][2] = trenRegistrado.getString("capacidad");

            for (int j = 1; j < trenes[0].length; j++) {

                System.out.println("Ingrese nuevo tren " + encabezadosTren[j] + ": ");
                trenes[0][j] = ValidadorDeTipo.ValidarString();
            }

            Document nuevosDatos = new Document("id", trenes[0][0])
                    .append("modelo", trenes[0][1])
                    .append("capacidad", trenes[0][2]);

            UpdateResult resultado = trenesMongo.replaceOne(
                    new Document("id", idBuscarTren),
                    nuevosDatos
            );

            if (resultado.getMatchedCount() > 0) {

                if (resultado.getModifiedCount() > 0) {
                    System.out.println("Tren actualizado correctamente.");
                } else {
                    System.out.println("El tren ya tenia esos mismos datos.");
                }

            } else {

                System.out.println("MongoDB no encontro el tren para actualizar.");
            }

        } else {

            System.out.println("Tren no encontrado.");
        }
    }


    static public void eliminarTren() {

        MongoCollection<Document> trenesMongo =
                ConexionMongoDB.conectar().getCollection("trenes");

        System.out.println("Ingrese el ID del tren que desea eliminar: ");
        String idEliminar = ValidadorDeTipo.ValidarString();

        Document trenRegistrado =
                trenesMongo.find(new Document("id", idEliminar)).first();

        if (trenRegistrado != null) {

            trenesMongo.deleteOne(new Document("id", idEliminar));

            if (trenes[0][0] != null && trenes[0][0].equals(idEliminar)) {

                for (int j = 0; j < trenes[0].length; j++) {
                    trenes[0][j] = null;
                }
            }

            System.out.println("Tren eliminado correctamente.");

        } else {

            System.out.println("Tren no encontrado.");
        }
    }


    // =========================================
    // ARRAY Y MATRICES DE TICKETS
    // =========================================

    static String[][] ticketes = new String[1][9];

    static String[] encabezadosTicket = {
            "id", "usuario", "origenRuta", "destinoRuta",
            "silla", "tren", "fecha", "hora", "precio"
    };


    static public void crearTicket() {

        MongoCollection<Document> ticketsMongo =
                ConexionMongoDB.conectar().getCollection("tickets");

        for (int i = 0; i < encabezadosTicket.length; i++) {
            System.out.println(encabezadosTicket[i]);
        }

        for (int i = 0; i < ticketes.length; i++) {

            for (int j = 0; j < ticketes[i].length; j++) {

                System.out.println("Ingrese dato del ticket " + encabezadosTicket[j] + ": ");
                ticketes[i][j] = ValidadorDeTipo.ValidarString();
            }

            Document filtro = new Document("id", ticketes[i][0]);

            Document ticketRegistrado = ticketsMongo.find(filtro).first();

            Document nuevoTicket = new Document("id", ticketes[i][0])
                    .append("usuario", ticketes[i][1])
                    .append("origenRuta", ticketes[i][2])
                    .append("destinoRuta", ticketes[i][3])
                    .append("silla", ticketes[i][4])
                    .append("tren", ticketes[i][5])
                    .append("fecha", ticketes[i][6])
                    .append("hora", ticketes[i][7])
                    .append("precio", ticketes[i][8]);

            if (ticketRegistrado == null) {

                ticketsMongo.insertOne(nuevoTicket);

                System.out.println("Ticket registrado correctamente.");

            } else {

                ticketsMongo.replaceOne(filtro, nuevoTicket);

                System.out.println("El ticket ya existia y fue reemplazado.");
            }
        }
    }


    static public void consultarTicket() {

        MongoCollection<Document> ticketsMongo =
                ConexionMongoDB.conectar().getCollection("tickets");

        Document ticketRegistrado = ticketsMongo.find().first();

        if (ticketRegistrado != null) {

            for (int j = 0; j < encabezadosTicket.length; j++) {
                ticketes[0][j] = ticketRegistrado.getString(encabezadosTicket[j]);
            }

            for (int i = 0; i < encabezadosTicket.length; i++) {
                System.out.print(encabezadosTicket[i] + "\t");
            }

            System.out.println();

            for (int i = 0; i < ticketes.length; i++) {

                for (int j = 0; j < ticketes[i].length; j++) {
                    System.out.print(ticketes[i][j] + "\t");
                }

                System.out.println();
            }

        } else {

            System.out.println("No hay tickets registrados.");
        }
    }


    static public void consultarTicketPorId() {

        MongoCollection<Document> ticketsMongo =
                ConexionMongoDB.conectar().getCollection("tickets");

        System.out.println("Ingrese el ID del ticket: ");
        String idBuscarTicket = ValidadorDeTipo.ValidarString();

        Document ticketRegistrado =
                ticketsMongo.find(new Document("id", idBuscarTicket)).first();

        if (ticketRegistrado != null) {

            for (int j = 0; j < encabezadosTicket.length; j++) {

                System.out.println(
                        encabezadosTicket[j] + ": " +
                                ticketRegistrado.getString(encabezadosTicket[j])
                );
            }

        } else {

            System.out.println("Ticket no encontrado.");
        }
    }


    static public void actualizarTicket() {

        MongoCollection<Document> ticketsMongo =
                ConexionMongoDB.conectar().getCollection("tickets");

        System.out.println("Ingrese el ID del ticket que desea actualizar: ");
        String idBuscarTicket = ValidadorDeTipo.ValidarString();

        Document ticketRegistrado =
                ticketsMongo.find(new Document("id", idBuscarTicket)).first();

        if (ticketRegistrado != null) {

            for (int j = 0; j < encabezadosTicket.length; j++) {
                ticketes[0][j] = ticketRegistrado.getString(encabezadosTicket[j]);
            }

            for (int j = 1; j < ticketes[0].length; j++) {

                System.out.println("Ingrese nuevo ticket " + encabezadosTicket[j] + ": ");
                ticketes[0][j] = ValidadorDeTipo.ValidarString();
            }

            Document nuevosDatos = new Document("id", ticketes[0][0])
                    .append("usuario", ticketes[0][1])
                    .append("origenRuta", ticketes[0][2])
                    .append("destinoRuta", ticketes[0][3])
                    .append("silla", ticketes[0][4])
                    .append("tren", ticketes[0][5])
                    .append("fecha", ticketes[0][6])
                    .append("hora", ticketes[0][7])
                    .append("precio", ticketes[0][8]);

            UpdateResult resultado = ticketsMongo.replaceOne(
                    new Document("id", idBuscarTicket),
                    nuevosDatos
            );

            if (resultado.getMatchedCount() > 0) {

                if (resultado.getModifiedCount() > 0) {
                    System.out.println("Ticket actualizado correctamente.");
                } else {
                    System.out.println("El ticket ya tenia esos mismos datos.");
                }

            } else {

                System.out.println("MongoDB no encontro el ticket para actualizar.");
            }

        } else {

            System.out.println("Ticket no encontrado.");
        }
    }


    static public void eliminarTicket() {

        MongoCollection<Document> ticketsMongo =
                ConexionMongoDB.conectar().getCollection("tickets");

        System.out.println("Ingrese el ID del ticket que desea eliminar: ");
        String idEliminar = ValidadorDeTipo.ValidarString();

        Document ticketRegistrado =
                ticketsMongo.find(new Document("id", idEliminar)).first();

        if (ticketRegistrado != null) {

            ticketsMongo.deleteOne(new Document("id", idEliminar));

            if (ticketes[0][0] != null && ticketes[0][0].equals(idEliminar)) {

                for (int j = 0; j < ticketes[0].length; j++) {
                    ticketes[0][j] = null;
                }
            }

            System.out.println("Ticket eliminado correctamente.");

        } else {

            System.out.println("Ticket no encontrado.");
        }
    }


    // =========================================
    // ARRAY Y MATRICES DE VENTAS
    // =========================================

    static String[][] ventas = new String[1][5];

    static String[] encabezadosVentas = {
            "idVenta", "idTicket", "cantidad", "precioUnitario", "total"
    };


    static public void crearVenta() {

        MongoCollection<Document> ventasMongo =
                ConexionMongoDB.conectar().getCollection("ventas");

        for (int i = 0; i < encabezadosVentas.length; i++) {
            System.out.println(encabezadosVentas[i]);
        }

        for (int i = 0; i < ventas.length; i++) {

            for (int j = 0; j < ventas[i].length - 1; j++) {

                System.out.println("Ingrese dato de la venta " + encabezadosVentas[j] + ": ");
                ventas[i][j] = ValidadorDeTipo.ValidarString();
            }

            int cantidad = Integer.parseInt(ventas[i][2]);
            double precioUnitario = Double.parseDouble(ventas[i][3]);

            double total = cantidad * precioUnitario;

            ventas[i][4] = String.valueOf(total);

            Document filtro = new Document("idVenta", ventas[i][0]);

            Document ventaRegistrada = ventasMongo.find(filtro).first();

            Document nuevaVenta = new Document("idVenta", ventas[i][0])
                    .append("idTicket", ventas[i][1])
                    .append("cantidad", ventas[i][2])
                    .append("precioUnitario", ventas[i][3])
                    .append("total", ventas[i][4]);

            if (ventaRegistrada == null) {

                ventasMongo.insertOne(nuevaVenta);

                System.out.println("Venta registrada correctamente.");

            } else {

                ventasMongo.replaceOne(filtro, nuevaVenta);

                System.out.println("La venta ya existia y fue reemplazada.");
            }
        }
    }


    static public void consultarVentas() {

        MongoCollection<Document> ventasMongo =
                ConexionMongoDB.conectar().getCollection("ventas");

        Document ventaRegistrada = ventasMongo.find().first();

        if (ventaRegistrada != null) {

            for (int j = 0; j < encabezadosVentas.length; j++) {
                ventas[0][j] = ventaRegistrada.getString(encabezadosVentas[j]);
            }

            for (int i = 0; i < encabezadosVentas.length; i++) {
                System.out.print(encabezadosVentas[i] + "\t");
            }

            System.out.println();

            for (int i = 0; i < ventas.length; i++) {

                for (int j = 0; j < ventas[i].length; j++) {
                    System.out.print(ventas[i][j] + "\t");
                }

                System.out.println();
            }

        } else {

            System.out.println("No hay ventas registradas.");
        }
    }


    static public void consultarVentasPorId() {

        MongoCollection<Document> ventasMongo =
                ConexionMongoDB.conectar().getCollection("ventas");

        System.out.println("Ingrese el ID de la venta: ");
        String idBuscarVenta = ValidadorDeTipo.ValidarString();

        Document ventaRegistrada =
                ventasMongo.find(new Document("idVenta", idBuscarVenta)).first();

        if (ventaRegistrada != null) {

            for (int j = 0; j < encabezadosVentas.length; j++) {

                System.out.println(
                        encabezadosVentas[j] + ": " +
                                ventaRegistrada.getString(encabezadosVentas[j])
                );
            }

        } else {

            System.out.println("Venta no encontrada.");
        }
    }


    static public void actualizarVentas() {

        MongoCollection<Document> ventasMongo =
                ConexionMongoDB.conectar().getCollection("ventas");

        System.out.println("Ingrese el ID de la venta que desea actualizar: ");
        String idBuscarVenta = ValidadorDeTipo.ValidarString();

        Document ventaRegistrada =
                ventasMongo.find(new Document("idVenta", idBuscarVenta)).first();

        if (ventaRegistrada != null) {

            for (int j = 0; j < encabezadosVentas.length; j++) {
                ventas[0][j] = ventaRegistrada.getString(encabezadosVentas[j]);
            }

            for (int j = 1; j < ventas[0].length - 1; j++) {

                System.out.println("Ingrese nueva venta " + encabezadosVentas[j] + ": ");
                ventas[0][j] = ValidadorDeTipo.ValidarString();
            }

            int cantidad = Integer.parseInt(ventas[0][2]);
            double precioUnitario = Double.parseDouble(ventas[0][3]);

            double total = cantidad * precioUnitario;

            ventas[0][4] = String.valueOf(total);

            Document nuevosDatos = new Document("idVenta", ventas[0][0])
                    .append("idTicket", ventas[0][1])
                    .append("cantidad", ventas[0][2])
                    .append("precioUnitario", ventas[0][3])
                    .append("total", ventas[0][4]);

            UpdateResult resultado = ventasMongo.replaceOne(
                    new Document("idVenta", idBuscarVenta),
                    nuevosDatos
            );

            if (resultado.getMatchedCount() > 0) {

                if (resultado.getModifiedCount() > 0) {
                    System.out.println("Venta actualizada correctamente.");
                } else {
                    System.out.println("La venta ya tenia esos mismos datos.");
                }

            } else {

                System.out.println("MongoDB no encontro la venta para actualizar.");
            }

        } else {

            System.out.println("Venta no encontrada.");
        }
    }


    static public void eliminarVenta() {

        MongoCollection<Document> ventasMongo =
                ConexionMongoDB.conectar().getCollection("ventas");

        System.out.println("Ingrese el ID de la venta que desea eliminar: ");
        String idEliminar = ValidadorDeTipo.ValidarString();

        Document ventaRegistrada =
                ventasMongo.find(new Document("idVenta", idEliminar)).first();

        if (ventaRegistrada != null) {

            ventasMongo.deleteOne(new Document("idVenta", idEliminar));

            if (ventas[0][0] != null && ventas[0][0].equals(idEliminar)) {

                for (int j = 0; j < ventas[0].length; j++) {
                    ventas[0][j] = null;
                }
            }

            System.out.println("Venta eliminada correctamente.");

        } else {

            System.out.println("Venta no encontrada.");
        }
    }


    // =========================================
    // GESTION DE CAJEROS
    // =========================================

    public static void registrarCajero() {

        MongoCollection<Document> cajeros =
                ConexionMongoDB.conectar().getCollection("cajeros");

        if (cajeros.find().first() == null) {

            System.out.println("Ingrese el tipo de usuario");
            rol = ValidadorDeTipo.ValidarString();

            System.out.println("Ingrese el password:");
            password = ValidadorDeTipo.ValidarString();

            Document cajero = new Document("rol", rol)
                    .append("password", password);

            cajeros.insertOne(cajero);

            System.out.println("Cajero registrado correctamente");

        } else {

            System.out.println("Ya existe un cajero registrado");
        }
    }


    public static void consultarCajero() {

        MongoCollection<Document> cajeros =
                ConexionMongoDB.conectar().getCollection("cajeros");

        Document cajeroRegistrado = cajeros.find().first();

        if (cajeroRegistrado != null) {

            System.out.println(
                    "Rol del cajero: " + cajeroRegistrado.getString("rol")
            );

        } else {

            System.out.println("No hay un cajero registrado");
        }
    }


    public static void actualizarCajero() {

        MongoCollection<Document> cajeros =
                ConexionMongoDB.conectar().getCollection("cajeros");

        Document cajeroRegistrado = cajeros.find().first();

        if (cajeroRegistrado != null) {

            System.out.println("Ingrese el nuevo rol del cajero:");
            rol = ValidadorDeTipo.ValidarString();

            System.out.println("Ingrese el nuevo password:");
            password = ValidadorDeTipo.ValidarString();

            Document nuevosDatos = new Document("rol", rol)
                    .append("password", password);

            UpdateResult resultado = cajeros.updateOne(
                    new Document("_id", cajeroRegistrado.getObjectId("_id")),
                    new Document("$set", nuevosDatos)
            );

            if (resultado.getMatchedCount() > 0) {

                if (resultado.getModifiedCount() > 0) {
                    System.out.println("Cajero actualizado correctamente");
                } else {
                    System.out.println("El cajero ya tenia esos mismos datos");
                }

            } else {

                System.out.println("No se encontro el cajero para actualizar");
            }

        } else {

            System.out.println("No hay un cajero registrado");
        }
    }


    public static void eliminarCajero() {

        MongoCollection<Document> cajeros =
                ConexionMongoDB.conectar().getCollection("cajeros");

        Document cajeroRegistrado = cajeros.find().first();

        if (cajeroRegistrado != null) {

            cajeros.deleteOne(
                    new Document("_id", cajeroRegistrado.getObjectId("_id"))
            );

            rol = null;
            password = null;

            System.out.println("Cajero eliminado correctamente");

        } else {

            System.out.println("No hay un cajero registrado");
        }
    }


    public static boolean iniciarsesion() {

        MongoCollection<Document> cajeros =
                ConexionMongoDB.conectar().getCollection("cajeros");

        Document cajeroRegistrado = cajeros.find().first();

        if (cajeroRegistrado != null) {

            System.out.println("Ingrese el usuario");
            String rolIngresado = ValidadorDeTipo.ValidarString();

            System.out.println("Ingrese el password:");
            String passwordIngresado = ValidadorDeTipo.ValidarString();

            Document filtro = new Document("rol", rolIngresado)
                    .append("password", passwordIngresado);

            Document resultado = cajeros.find(filtro).first();

            if (resultado != null) {

                System.out.println("Inicio de sesion exitoso");
                return true;

            } else {

                System.out.println("Rol o password incorrectos");
                return false;
            }

        } else {

            System.out.println("No hay un cajero registrado");
            return false;
        }
    }
}
