package frgp.utn.edu.ar.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import frgp.utn.edu.ar.entidades.Especialidad;
import frgp.utn.edu.ar.entidades.Medico;
import frgp.utn.edu.ar.entidades.Paciente;
import frgp.utn.edu.ar.entidades.Turno;
import frgp.utn.edu.ar.entidades.Usuario;
import frgp.utn.edu.ar.negocioImp.EspecialidadNegocio;
import frgp.utn.edu.ar.negocioImp.MedicoNegocio;
import frgp.utn.edu.ar.negocioImp.PacienteNegocio;
import frgp.utn.edu.ar.negocioImp.TurnosNegocio;
import frgp.utn.edu.ar.negocioImp.UsuarioNegocio;

public class CargadoDeDatos 
{
    public static void main( String[] args )
    {

    	//Inicializacion beans
    	ApplicationContext appContext = new ClassPathXmlApplicationContext("frgp/utn/edu/ar/resources/Beans.xml");
    	
		MedicoNegocio medicoNegocio = (MedicoNegocio) appContext.getBean("beanMedicoNegocio");
		EspecialidadNegocio especialidadNegocio = (EspecialidadNegocio) appContext.getBean("beanEspecialidadNegocio");
		TurnosNegocio turnoNegocio = (TurnosNegocio) appContext.getBean("beanTurnosNegocio");
		PacienteNegocio pacienteNegocio = (PacienteNegocio) appContext.getBean("beanPacienteNegocio");
		UsuarioNegocio usuarioNegocio = (UsuarioNegocio) appContext.getBean("beanUsuarioNegocio");
		
    	
    	//------------------------ ALTA ------------------------
    	
    	//ALTA DE ESPECIALIDADES
    	Especialidad especialidad1 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad1.setId(1);
    	especialidad1.setNombre("Cirugia General");
    	especialidad1.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad1);
    	
    	Especialidad especialidad2 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad2.setId(2);
    	especialidad2.setNombre("Pediatria");
    	especialidad2.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad2);
    	
    	Especialidad especialidad3 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad3.setId(3);
    	especialidad3.setNombre("Dermatologia");
    	especialidad3.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad3);
    	
    	Especialidad especialidad4 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad4.setId(4);
    	especialidad4.setNombre("Cardiologia");
    	especialidad4.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad4);
    	
    	Especialidad especialidad5 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad5.setId(5);
    	especialidad5.setNombre("Radiologia");
    	especialidad5.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad5);
    	
    	Especialidad especialidad6 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad6.setId(6);
    	especialidad6.setNombre("Odontologia");
    	especialidad6.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad6);
    	
    	Especialidad especialidad7 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad7.setId(7);
    	especialidad7.setNombre("Oncologia");
    	especialidad7.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad7);
    	
    	Especialidad especialidad8 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad8.setId(8);
    	especialidad8.setNombre("Oftalmologia");
    	especialidad8.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad8);
    	
    	Especialidad especialidad9 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad9.setId(9);
    	especialidad9.setNombre("Diabetologia");
    	especialidad9.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad9);
    	
    	Especialidad especialidad10 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad10.setId(10);
    	especialidad10.setNombre("Otorrinolaringologia");
    	especialidad10.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad10);
    	
    	Especialidad especialidad11 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad11.setId(11);
    	especialidad11.setNombre("Kinesiologia");
    	especialidad11.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad11);
    	
    	Especialidad especialidad12 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad12.setId(12);
    	especialidad12.setNombre("Traumatologia");
    	especialidad12.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad12);
    	
    	Especialidad especialidad13 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad13.setId(13);
    	especialidad13.setNombre("Endocrinologia");
    	especialidad13.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad13);
    	
    	Especialidad especialidad14 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad14.setId(14);
    	especialidad14.setNombre("Neurologia");
    	especialidad14.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad14);
    	
    	Especialidad especialidad15 = (Especialidad) appContext.getBean("beanEspecialidad");
    	especialidad15.setId(15);
    	especialidad15.setNombre("Psicologia");
    	especialidad15.setEstado(true);
    	especialidadNegocio.addEspecialidad(especialidad15);
    	
    	
    	
    	
    	//ALTA DE MÃ‰DICOS Y USUARIOS
    	//1
    	Usuario usuario1 = (Usuario) appContext.getBean("beanUsuario");
    	usuario1.setNombre_usuario("OfeOliveira95");
    	usuario1.setContrasenia("Qwerty123");
    	usuario1.setEstado(true);
    	
		Medico medico1 = (Medico) appContext.getBean("beanMedico");

    	medico1.setLegajo(1);
    	medico1.setNombre("Ofelia");
    	medico1.setApellido("Oliveira");
    	medico1.setFechaNacimiento("01/02/1995");
    	medico1.setEmail("ofelia_oliveira@gmail.com");
    	medico1.setSexo('F');
    	medico1.setLocalidad("Gral. Pacheco");
    	medico1.setDireccion("Corrientes 321");
    	medico1.setTelefono(1121645896);
    	medico1.setEstado(true);
    	medico1.setUsuario(usuario1);
    	medico1.setDiasQueTrabaja("Lunes,Martes,Miercoles,Jueves,Viernes");
    	medico1.setHoraEntrada("14:00");
    	medico1.setHoraSalida("18:00");
    	medico1.setEspecialidad(especialidad10);
    	
    	
    	usuarioNegocio.Add(usuario1);
    	medicoNegocio.Add(medico1);
    	
    	//2
    	Usuario usuario2 = (Usuario) appContext.getBean("beanUsuario");
    	usuario2.setNombre_usuario("PhoenixDy");
    	usuario2.setContrasenia("Asdf1245");
    	usuario2.setEstado(true);
    	
		Medico medico2 = (Medico) appContext.getBean("beanMedico");

    	medico2.setLegajo(2);
    	medico2.setNombre("Phoebe");
    	medico2.setApellido("Dynevor");
    	medico2.setFechaNacimiento("02/04/1996");
    	medico2.setEmail("DocPhoebeDy@gmail.com");
    	medico2.setSexo('F');
    	medico2.setLocalidad("Don Torcuato");
    	medico2.setDireccion("Gallardo 1698");
    	medico2.setTelefono(1112458956);
    	medico2.setEstado(true);
    	medico2.setUsuario(usuario2);
    	medico2.setDiasQueTrabaja("Martes,Miercoles,Jueves,Viernes,Sabado");
    	medico2.setHoraEntrada("10:00");
    	medico2.setHoraSalida("16:00");
    	medico2.setEspecialidad(especialidad9);
    	
    	
    	usuarioNegocio.Add(usuario2);
    	medicoNegocio.Add(medico2);
    	
    	//3
    	Usuario usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("NiCough");
    	usuario.setContrasenia("Yuiop7845");
    	usuario.setEstado(true);
    	
		Medico medico3 = (Medico) appContext.getBean("beanMedico");

    	medico3.setLegajo(3);
    	medico3.setNombre("Nicola");
    	medico3.setApellido("Coughlan");
    	medico3.setFechaNacimiento("03/06/1998");
    	medico3.setEmail("NiCoughlan@gmail.com");
    	medico3.setSexo('F');
    	medico3.setLocalidad("El Talar");
    	medico3.setDireccion("Vivaldi 1584");
    	medico3.setTelefono(1112365568);
    	medico3.setEstado(true);
    	medico3.setUsuario(usuario);
    	medico3.setDiasQueTrabaja("Jueves,Viernes,Sabado");
    	medico3.setHoraEntrada("11:00");
    	medico3.setHoraSalida("18:00");
    	medico3.setEspecialidad(especialidad8);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico3);;
    	
    	//4
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("RubyRu");
    	usuario.setContrasenia("hjkLnm123456");
    	usuario.setEstado(true);
    	
		Medico medico4 = (Medico) appContext.getBean("beanMedico");

    	medico4.setLegajo(4);
    	medico4.setNombre("Ruby");
    	medico4.setApellido("Stokes");
    	medico4.setFechaNacimiento("14/08/1998");
    	medico4.setEmail("RubyStokes.lic@gmail.com");
    	medico4.setSexo('F');
    	medico4.setLocalidad("Ingeniero Adolfo Sourdeaux");
    	medico4.setDireccion("Alvarez Prado 5051");
    	medico4.setTelefono(1112365568);
    	medico4.setEstado(true);
    	medico4.setUsuario(usuario);
    	medico4.setDiasQueTrabaja("Lunes,Martes,Miercoles,Jueves");
    	medico4.setHoraEntrada("12:00");
    	medico4.setHoraSalida("19:00");
    	medico4.setEspecialidad(especialidad7);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico4);
    	
    	//5
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("Simons1969");
    	usuario.setContrasenia("ZXCvbn1254");
    	usuario.setEstado(true);
    	
		Medico medico5 = (Medico) appContext.getBean("beanMedico");

    	medico5.setLegajo(5);
    	medico5.setNombre("Simon");
    	medico5.setApellido("Ludders");
    	medico5.setFechaNacimiento("29/09/1969");
    	medico5.setEmail("LudderSimon@gmail.com");
    	medico5.setSexo('M');
    	medico5.setLocalidad("Los Polvorines");
    	medico5.setDireccion("Moreno Perito 1067");
    	medico5.setTelefono(1114253685);
    	medico5.setEstado(true);
    	medico5.setUsuario(usuario);
    	medico5.setDiasQueTrabaja("Miercoles,Jueves,Viernes,Sabado");
    	medico5.setHoraEntrada("08:00");
    	medico5.setHoraSalida("16:00");
    	medico5.setEspecialidad(especialidad6);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico5);
    	
    	//6
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("NewLuke1998");
    	usuario.setContrasenia("lukkNeww1212");
    	usuario.setEstado(true);
    	
		Medico medico6 = (Medico) appContext.getBean("beanMedico");

    	medico6.setLegajo(6);
    	medico6.setNombre("Luke");
    	medico6.setApellido("Newton");
    	medico6.setFechaNacimiento("07/10/1994");
    	medico6.setEmail("Luke.13.01.1998@gmail.com");
    	medico6.setSexo('M');
    	medico6.setLocalidad("San Miguel");
    	medico6.setDireccion("San Lorenzo 1299");
    	medico6.setTelefono(1145253663);
    	medico6.setEstado(true);
    	medico6.setUsuario(usuario);
    	medico6.setDiasQueTrabaja("Lunes,Jueves,Viernes");
    	medico6.setHoraEntrada("09:00");
    	medico6.setHoraSalida("17:00");
    	medico6.setEspecialidad(especialidad5);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico6);
    	
    	//7
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("BaileysJonathan");
    	usuario.setContrasenia("Baileys1979");
    	usuario.setEstado(true);
    	
		Medico medico7 = (Medico) appContext.getBean("beanMedico");

    	medico7.setLegajo(7);
    	medico7.setNombre("Jonathan");
    	medico7.setApellido("Bailey");
    	medico7.setFechaNacimiento("09/11/1979");
    	medico7.setEmail("JonathanBailey@gmail.com");
    	medico7.setSexo('M');
    	medico7.setLocalidad("San Miguel");
    	medico7.setDireccion("Guemes 954");
    	medico7.setTelefono(1185695421);
    	medico7.setEstado(true);
    	medico7.setUsuario(usuario);
    	medico7.setDiasQueTrabaja("Jueves,Viernes,Sabado");
    	medico7.setHoraEntrada("07:30");
    	medico7.setHoraSalida("15:30");
    	medico7.setEspecialidad(especialidad4);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico7);
    	
    	//8
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("LulukeThompson");
    	usuario.setContrasenia("123456789");
    	usuario.setEstado(true);
    	
		Medico medico8 = (Medico) appContext.getBean("beanMedico");

    	medico8.setLegajo(8);
    	medico8.setNombre("Luke");
    	medico8.setApellido("Thompson");
    	medico8.setFechaNacimiento("07/05/1983");
    	medico8.setEmail("Thompson.Luke.1983@gmail.com");
    	medico8.setSexo('M');
    	medico8.setLocalidad("Don Torcuato");
    	medico8.setDireccion("Emilio Lamarca 3298");
    	medico8.setTelefono(1145685236);
    	medico8.setEstado(true);
    	medico8.setUsuario(usuario);
    	medico8.setDiasQueTrabaja("Lunes,Martes,Miercoles,Domingo");
    	medico8.setHoraEntrada("08:00");
    	medico8.setHoraSalida("14:00");
    	medico8.setEspecialidad(especialidad3);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico8);
    	
    	//9
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("JessieClau");
    	usuario.setContrasenia("Clau1994");
    	usuario.setEstado(true);
    	
		Medico medico9 = (Medico) appContext.getBean("beanMedico");

    	medico9.setLegajo(9);
    	medico9.setNombre("Claudia");
    	medico9.setApellido("Jessie");
    	medico9.setFechaNacimiento("23/12/1994");
    	medico9.setEmail("Jessie_Clau@gmail.com");
    	medico9.setSexo('F');
    	medico9.setLocalidad("Gral. Pacheco");
    	medico9.setDireccion("Olegario Victor Andrade 399");
    	medico9.setTelefono(1114258745);
    	medico9.setEstado(true);
    	medico9.setUsuario(usuario);
    	medico9.setDiasQueTrabaja("Martes,Jueves,Viernes,Sabado");
    	medico9.setHoraEntrada("12:00");
    	medico9.setHoraSalida("18:00");
    	medico9.setEspecialidad(especialidad2);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico9);
    	
    	//10
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("CaLynch");
    	usuario.setContrasenia("hjkdl.1212");
    	usuario.setEstado(true);
    	
		Medico medico10 = (Medico) appContext.getBean("beanMedico");

    	medico10.setLegajo(10);
    	medico10.setNombre("Calam");
    	medico10.setApellido("Lynch");
    	medico10.setFechaNacimiento("24/07/1984");
    	medico10.setEmail("CLynch.lic@gmail.com");
    	medico10.setSexo('M');
    	medico10.setLocalidad("Ricardo Rojas");
    	medico10.setDireccion("Sarmiento 2599");
    	medico10.setTelefono(1145325689);
    	medico10.setEstado(true);
    	medico10.setUsuario(usuario);
    	medico10.setDiasQueTrabaja("Lunes,Miercoles,Viernes,Domingo");
    	medico10.setHoraEntrada("10:00");
    	medico10.setHoraSalida("18:00");
    	medico10.setEspecialidad(especialidad1);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico10);
    	
    	//12
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("Pepe11");
    	usuario.setContrasenia("Pepe11");
    	usuario.setEstado(true);
    	
		Medico medico12 = (Medico) appContext.getBean("beanMedico");

    	medico12.setLegajo(20);
    	medico12.setNombre("Pepe");
    	medico12.setApellido("Garcia");
    	medico12.setFechaNacimiento("24/07/1988");
    	medico12.setEmail("pepe11@gmail.com");
    	medico12.setSexo('M');
    	medico12.setLocalidad("Tigre");
    	medico12.setDireccion("Sarmiento 999");
    	medico12.setTelefono(1145559988);
    	medico12.setEstado(true);
    	medico12.setUsuario(usuario);
    	medico12.setDiasQueTrabaja("Lunes,Miercoles,Viernes,Domingo");
    	medico12.setHoraEntrada("10:00");
    	medico12.setHoraSalida("12:00");
    	medico12.setEspecialidad(especialidad1);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico12);
    	
    	//13
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("Pipo11");
    	usuario.setContrasenia("Pipo11");
    	usuario.setEstado(true);
    	
		Medico medico13 = (Medico) appContext.getBean("beanMedico");

    	medico13.setLegajo(21);
    	medico13.setNombre("Pipo");
    	medico13.setApellido("Garzon");
    	medico13.setFechaNacimiento("24/07/1977");
    	medico13.setEmail("pipo@gmail.com");
    	medico13.setSexo('M');
    	medico13.setLocalidad("Castelar");
    	medico13.setDireccion("Cumber 999");
    	medico13.setTelefono(1141119933);
    	medico13.setEstado(true);
    	medico13.setUsuario(usuario);
    	medico13.setDiasQueTrabaja("Lunes,Miercoles,Viernes,Domingo");
    	medico13.setHoraEntrada("11:00");
    	medico13.setHoraSalida("14:00");
    	medico13.setEspecialidad(especialidad1);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico13);
    	
    	//13
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("Ana11");
    	usuario.setContrasenia("Ana11");
    	usuario.setEstado(true);
    	
		Medico medico14 = (Medico) appContext.getBean("beanMedico");

    	medico14.setLegajo(22);
    	medico14.setNombre("Ana");
    	medico14.setApellido("Gaez");
    	medico14.setFechaNacimiento("24/07/2000");
    	medico14.setEmail("pepe11@gmail.com");
    	medico14.setSexo('F');
    	medico14.setLocalidad("Boulogne");
    	medico14.setDireccion("Bulnes 1999");
    	medico14.setTelefono(1141119988);
    	medico14.setEstado(true);
    	medico14.setUsuario(usuario);
    	medico14.setDiasQueTrabaja("Lunes,Miercoles");
    	medico14.setHoraEntrada("11:00");
    	medico14.setHoraSalida("15:00");
    	medico14.setEspecialidad(especialidad1);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico14);
    	
    	//14
    	usuario = (Usuario) appContext.getBean("beanUsuario");
    	usuario.setNombre_usuario("Irina11");
    	usuario.setContrasenia("Irina11");
    	usuario.setEstado(true);
    	
		Medico medico15 = (Medico) appContext.getBean("beanMedico");

    	medico15.setLegajo(23);
    	medico15.setNombre("Irina");
    	medico15.setApellido("Paez");
    	medico15.setFechaNacimiento("24/07/1990");
    	medico15.setEmail("paez11@gmail.com");
    	medico15.setSexo('F');
    	medico15.setLocalidad("San Fernando");
    	medico15.setDireccion("Gascon 999");
    	medico15.setTelefono(1141119922);
    	medico15.setEstado(true);
    	medico15.setUsuario(usuario);
    	medico15.setDiasQueTrabaja("Miercoles,Viernes");
    	medico15.setHoraEntrada("11:00");
    	medico15.setHoraSalida("16:00");
    	medico15.setEspecialidad(especialidad1);
    	
    	usuarioNegocio.Add(usuario);
    	medicoNegocio.Add(medico15);
    	
		//ALTA DE PACIENTES
    	
    	Paciente paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215362);
    	paciente.setNombre("Simon");
    	paciente.setApellido("Basset");
    	paciente.setTelefono(1123561524);
    	paciente.setDireccion("Virrey Cevallos 3098");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("02/05/1999");
    	paciente.setCorreo("BassetSimon@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215363);
    	paciente.setNombre("Francesca");
    	paciente.setApellido("Bridgerton");
    	paciente.setTelefono(1145785454);
    	paciente.setDireccion("Av. San Martin 2007");
    	paciente.setLocalidad("Bella Vista");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("15/06/2001");
    	paciente.setCorreo("FranchescaBridgertone@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215364);
    	paciente.setNombre("Penelope");
    	paciente.setApellido("Featherington");
    	paciente.setTelefono(1122553366);
    	paciente.setDireccion("Gelly y Obes 258");
    	paciente.setLocalidad("Muniiz");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("19/12/2000");
    	paciente.setCorreo("Pen.Featherington-Lady@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215365);
    	paciente.setNombre("Edwina");
    	paciente.setApellido("Sharma");
    	paciente.setTelefono(1144558788);
    	paciente.setDireccion("Monteagudo 2599");
    	paciente.setLocalidad("San Miguel");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("16/11/2002");
    	paciente.setCorreo("Edwina_Sharma258@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215366);
    	paciente.setNombre("Theodore");
    	paciente.setApellido("Sharpe");
    	paciente.setTelefono(1196568844);
    	paciente.setDireccion("Blandengues 2500");
    	paciente.setLocalidad("Jose C. Paz");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("30/04/1998");
    	paciente.setCorreo("TheoSharpe@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215367);
    	paciente.setNombre("Sienna");
    	paciente.setApellido("Rosso");
    	paciente.setTelefono(1156324456);
    	paciente.setDireccion("Pasteur 4213");
    	paciente.setLocalidad("Virreyes");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("27/09/2002");
    	paciente.setCorreo("SiennaRosso_@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215368);
    	paciente.setNombre("Genevieve");
    	paciente.setApellido("Delacroix");
    	paciente.setTelefono(1123554678);
    	paciente.setDireccion("Arata 2138");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("03/01/1997");
    	paciente.setCorreo("MadameDelacroix@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215369);
    	paciente.setNombre("Agatha");
    	paciente.setApellido("Danbury");
    	paciente.setTelefono(1124565577);
    	paciente.setDireccion("Esquiu 198");
    	paciente.setLocalidad("Rincon de Milberg");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("12/12/1998");
    	paciente.setCorreo("Lady.Danbury@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215370);
    	paciente.setNombre("Cressida");
    	paciente.setApellido("Cowper");
    	paciente.setTelefono(1124545665);
    	paciente.setDireccion("Pozo de Vargas 498");
    	paciente.setLocalidad("Troncos del Talar");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("13/10/1997");
    	paciente.setCorreo("CressidaCocowper@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(40215371);
    	paciente.setNombre("Marina");
    	paciente.setApellido("Thompson");
    	paciente.setTelefono(1145542552);
    	paciente.setDireccion("Liniers 525");
    	paciente.setLocalidad("El Talar");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("18/07/2000");
    	paciente.setCorreo("Maariinaa.Thoompsoon@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(28231000);
    	paciente.setNombre("Adam");
    	paciente.setApellido("Sandler");
    	paciente.setTelefono(1199887744);
    	paciente.setDireccion("Arata 1510");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("25/08/1998");
    	paciente.setCorreo("Lic.Sandler.Adam@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(28231001);
    	paciente.setNombre("Will");
    	paciente.setApellido("Smith");
    	paciente.setTelefono(1133366655);
    	paciente.setDireccion("Malvinas 1216");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("10/05/1997");
    	paciente.setCorreo("willywonka@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(28231002);
    	paciente.setNombre("Emma");
    	paciente.setApellido("Watson");
    	paciente.setTelefono(1122224444);
    	paciente.setDireccion("Suiza 1741");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("20/10/2000");
    	paciente.setCorreo("emmaWatson02@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(30000001);
    	paciente.setNombre("Lionel");
    	paciente.setApellido("Messi");
    	paciente.setTelefono(1145542544);
    	paciente.setDireccion("Roca 520");
    	paciente.setLocalidad("Pacheco");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("18/07/1984");
    	paciente.setCorreo("messi@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(30000002);
    	paciente.setNombre("Cristiano");
    	paciente.setApellido("Ronaldo");
    	paciente.setTelefono(1145500544);
    	paciente.setDireccion("Higgins 1040");
    	paciente.setLocalidad("Pacheco");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("18/04/1980");
    	paciente.setCorreo("ronaldo@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	paciente = (Paciente) appContext.getBean("beanPaciente");
    	paciente.setDNI(30000003);
    	paciente.setNombre("Martin");
    	paciente.setApellido("Palermo");
    	paciente.setTelefono(1111542544);
    	paciente.setDireccion("Posadas 1030");
    	paciente.setLocalidad("Don Torcuato");
    	paciente.setProvincia("Buenos Aires");
    	paciente.setFechaNac("18/07/1979");
    	paciente.setCorreo("titan_palermo@gmail.com");
    	paciente.setEstado(true);
    	pacienteNegocio.AddPaciente(paciente);
    	
    	//ALTA DE TURNOS
    	
    	Turno turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos1 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos1 = medicoNegocio.ReadOne(2);
    	Paciente pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215369);
    	
    	turnos.setMedico(medicoTurnos1);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("20/04/2024");
    	turnos.setHora("14:00");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Ausente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno"); 
    	
		Medico medicoTurnos2 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos2 = medicoNegocio.ReadOne(2);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215369);
    	
    	turnos.setMedico(medicoTurnos2);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("19/06/2024");
    	turnos.setHora("15:00");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos3 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos3 = medicoNegocio.ReadOne(4);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215371);
    	
    	turnos.setMedico(medicoTurnos3);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("15/02/2024");
    	turnos.setHora("14:30");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos4 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos4 = medicoNegocio.ReadOne(7);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215370);
    	
    	turnos.setMedico(medicoTurnos4);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("21/12/2023");
    	turnos.setHora("13:30");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos5 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos5 = medicoNegocio.ReadOne(6);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215366);
    	
    	turnos.setMedico(medicoTurnos5);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("01/04/2024");
    	turnos.setHora("15:20");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos6 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos6 = medicoNegocio.ReadOne(6);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215368);
    	
    	turnos.setMedico(medicoTurnos6);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("22/07/2024");
    	turnos.setHora("09:40");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos7 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos7 = medicoNegocio.ReadOne(2);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215362);
    	
    	turnos.setMedico(medicoTurnos7);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("15/02/2024");
    	turnos.setHora("12:15");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);
    	
    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos8 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos8 = medicoNegocio.ReadOne(2);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215364);
    	
    	turnos.setMedico(medicoTurnos8);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("26/03/2024");
    	turnos.setHora("10:45");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Ausente");
    	turnos.setEstadoRegistro(true);

    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos9 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos9 = medicoNegocio.ReadOne(3);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215369);
    	
    	turnos.setMedico(medicoTurnos9);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("17/02/2024");
    	turnos.setHora("11:30");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Presente");
    	turnos.setEstadoRegistro(true);

    	turnoNegocio.AddTurno(turnos);
    	
    	
    	turnos = (Turno) appContext.getBean("beanTurno");
    	
		Medico medicoTurnos10 = (Medico) appContext.getBean("beanMedico");
    	medicoTurnos10 = medicoNegocio.ReadOne(10);
    	pacienteTurnos = (Paciente) appContext.getBean("beanPaciente");
    	pacienteTurnos = pacienteNegocio.ReadOnePaciente(40215367);
    	
    	turnos.setMedico(medicoTurnos10);
    	turnos.setPaciente(pacienteTurnos);
    	turnos.setFecha("24/05/2024");
    	turnos.setHora("14:50");
    	turnos.setObservaciones("Ninguna");
    	turnos.setEstadoTurno("Pendiente");
    	turnos.setEstadoRegistro(true);

    	turnoNegocio.AddTurno(turnos);
    	    	
    	// ------------------------ MODIFICACION ------------------------
    	
    	Medico medicoX = medicoNegocio.ReadOne(4);
    	medicoX.setNombre("Juan");
		medicoNegocio.Update(medicoX);
		
    	Especialidad especialidadX = especialidadNegocio.getEspecialidadById(2);
    	especialidadX.setNombre("Pediatria");
		especialidadNegocio.updateEspecialidad(especialidadX);
    	
		Usuario usuarioX = usuarioNegocio.ReadOne("BaileysJonathan");
		usuarioX.setContrasenia("Baileys1122");
		usuarioNegocio.Update(usuarioX);
    	
    	Paciente pacienteX = pacienteNegocio.ReadOnePaciente(40215362);
    	pacienteX.setNombre("Roman");
		pacienteNegocio.UpdatePaciente(pacienteX);
		
    	Turno turnoX = turnoNegocio.ReadOneTurno(1);
    	turnoX.setEstadoTurno("Presente");
		turnoNegocio.UpdateTurno(turnoX);
    	
    	// ------------------------ READ ALL ------------------------
    	
    	//Pacientes
    	List<Paciente> pacientes = pacienteNegocio.ReadAllPacientes();
    	System.out.println("------- LISTA DE PACIENTES -------");
    	for (Paciente p : pacientes) {
        	System.out.println(p.toString());
    	}
    	System.out.println("------- FIN LISTA DE PACIENTES -------\n");
    	
    	//Medicos
    	List<Medico> medicos = medicoNegocio.ReadAll();
    	System.out.println("------- LISTA DE Medicos -------");
    	for (Medico m : medicos) {
        	System.out.println(m.toString());
    	}
    	System.out.println("------- FIN LISTA DE Medicos -------\n");
    	
    	//Usuarios
    	List<Usuario> usuarios = usuarioNegocio.ReadAll();
    	System.out.println("------- LISTA DE Usuarios -------");
    	for (Usuario u : usuarios) {
        	System.out.println(u.toString());
    	}
    	System.out.println("------- FIN LISTA DE Usuarios -------\n");
    	
    	//Turnos
    	List<Turno> turnos1 = turnoNegocio.ReadAllTurnos();
    	System.out.println("------- LISTA DE Turnos -------");
    	for (Turno t : turnos1) {
        	System.out.println(t.toString());
    	}
    	System.out.println("------- FIN LISTA DE Turnos -------\n");
    	
    	//Turnos
    	List<Especialidad> especialidades = especialidadNegocio.getAllEspecialidades();
    	System.out.println("------- LISTA DE Especialidades -------");
    	for (Especialidad e : especialidades) {
        	System.out.println(e.toString());
    	}
    	System.out.println("------- FIN LISTA DE Especialidades -------\n");
    	
    	// ------------------------ DELETE ------------------------
        
    	Turno turnoDelete = turnoNegocio.ReadOneTurno(3);
        turnoDelete.setEstadoRegistro(false);
        turnoNegocio.DeleteTurno(turnoDelete);
        
    }
}
