
package Daos;

import Clases.Aula;
import Clases.Esporadica;
import Clases.Periodica;
import Clases.Periodo;
import Dtos.ListaReservaDTO;
import Dtos.ReservasSolapadasDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public interface ReservaDAO {
    
    public ArrayList<ListaReservaDTO> buscarReserva(String tipoAula, Date fecha) throws SQLException, ClassNotFoundException;
    public ArrayList<ListaReservaDTO> buscarReservaCurso(String ano,String materia) throws SQLException, ClassNotFoundException;
    public ArrayList<Aula> aulasDisponibles(ArrayList<Aula> listaAulas,Date fecha ,Time horaInicio ,int duracion)throws SQLException, ClassNotFoundException; 
    public  ArrayList<Aula> aulasDisponibles(ArrayList<Aula> criterio,String dia,Time horacioInicio,int dur,Periodo periodo)throws SQLException, ClassNotFoundException;
    public void registrarReserva(Esporadica esporadica)throws SQLException, ClassNotFoundException;
    public void registrarReserva(Periodica periodica)throws SQLException, ClassNotFoundException;
    public ArrayList<ReservasSolapadasDTO> aulasSolapadas(ArrayList<Aula> listaAulas,Date fecha ,Time horaInicio ,int duracion) throws SQLException, ClassNotFoundException;
    public ArrayList<ReservasSolapadasDTO> aulasSolapadas(ArrayList<Aula> criterio2,String dia,Time time,int dur,Periodo periodo1)throws SQLException, ClassNotFoundException; 
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    
}
