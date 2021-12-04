using CrearCliente;
using Cuota;
using System;
using System.Collections.Generic;

namespace PruebaCliente
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Menú Principal: \n1.Buscar \n2.Crear");
            int codigoMenu = Convert.ToInt32(Console.ReadLine());
            switch (codigoMenu)
            {
                case 1:
                    Console.WriteLine("Ingrese el código del prestamo:");
                    int codigo = Convert.ToInt32(Console.ReadLine());
                    consumeWebServiceFind(codigo);
                    break;
                case 2:
                    consumeWebServiceCreate();
                    break;
            }
       
        }

        private static void consumeWebServiceFind(int id)
        {
            cuotaPrestamoPortClient client = new cuotaPrestamoPortClient();
            obtenerPrestamoIdRequest request = new obtenerPrestamoIdRequest { codigoPrestamo = id };
            cuotaPrestamoRS[] cuotas = client.obtenerPrestamoId(request);
            if (cuotas.Length == 0)
            {
                Console.WriteLine("No existe el prestamo con el código:" + id);
            }
            else
            {
                obtenerPrestamoIdResponse response = new obtenerPrestamoIdResponse(cuotas);
                for (int i = 0; i < response.obtenerPrestamoIdResponse1.Length; i++)
                {
                    Console.WriteLine("-----------------------------------------------"
                     );
                    Console.WriteLine("Codigo:" + response.obtenerPrestamoIdResponse1[i].codigo
                                    + "\nCodigo Prestamo:" + response.obtenerPrestamoIdResponse1[i].codigoPrestamo
                                    + "\nAño:" + response.obtenerPrestamoIdResponse1[i].anio
                                    + "\nMes:" + response.obtenerPrestamoIdResponse1[i].mes
                                    + "\nCuota:" + response.obtenerPrestamoIdResponse1[i].cuota
                                    + "\nCuota Interes:" + response.obtenerPrestamoIdResponse1[i].cuotaInteres
                                    + "\nCuota Seguro:" + response.obtenerPrestamoIdResponse1[i].cuotaSeguro
                                    + "\nCapital:" + response.obtenerPrestamoIdResponse1[i].capital
                                    + "\nSaldo Anterior:" + response.obtenerPrestamoIdResponse1[i].saldoAnterior
                                    + "\nSaldo Actual:" + response.obtenerPrestamoIdResponse1[i].saldoActual
                                    + "\nEstado:" + response.obtenerPrestamoIdResponse1[i].estado
                                    + "\nFecha Maximo de Pago:" + response.obtenerPrestamoIdResponse1[i].fechaMaxPago
                                    + "\nValor Pago:" + response.obtenerPrestamoIdResponse1[i].valorPago
                        );
                 
                }
                Console.WriteLine("-----------------------------------------------"
                     );
            }
        }

        private static void consumeWebServiceCreate()
        {
            ClientePortClient client = new ClientePortClient();
            Cliente clientenew = new Cliente();
            clientenew.id = "3";
            clientenew.tipoIdentificacion = "CED";
            clientenew.identificacion = "1706855580";
            clientenew.apellidoPaterno = "Zuniga";
            clientenew.apellidoPaterno = "Vera";
            clientenew.nombre1 = "Sebastian";
            clientenew.nombre2 = "Alejandro";
            clientenew.provincia = "Pichincha";
            clientenew.canton = "Armenia";
            clientenew.parroquia = "Mirasierra";
            clientenew.direccion = "Oasis";
            clientenew.direccion = "telefono";
            clientenew.email = "sazuniga@espe.edu.ec";
            clientenew.fechaNaciemiento = new DateTime(1998,03,05);
            clientenew.estadoCivil = "Soltero";
            clientenew.estadoBancaWeb = "S";
            clientenew.estado = "ACT";
            createdClienteReturnIdRequest request = new createdClienteReturnIdRequest { Cliente = clientenew};
            createdClienteReturnIdResponse response= client.createdClienteReturnId(request);
            if (response == null) {
                Console.WriteLine("El cliente con la cedula:" + clientenew.identificacion+"ya existe");
            }
            else
            {
                Console.WriteLine("El id del usuario es el siguiente:" + response.id);
            }


        }
    }
}
