package pe.com.tizen.login;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pe.com.tizen.login.adapter.UsuarioAdapter;
import pe.com.tizen.login.entity.Usuario;

/**
 * Created by Alumnos on 21/04/2015.
 */
public class PaginaInicioActivity extends ActionBarActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pagina_inicio);

        List<Usuario> lstUsuarios = new ArrayList<Usuario>();
        ListView listViewUsuarios = (ListView)findViewById(R.id.txtListaUsuario);


        Usuario usuario1 = new Usuario();
        usuario1.setUsuario("Renato");
        usuario1.setPassword("renato123");

        Usuario usuario2 = new Usuario();
        usuario1.setUsuario("Juan");
        usuario1.setPassword("juan123");

        Usuario usuario3 = new Usuario();
        usuario1.setUsuario("Pedro");
        usuario1.setPassword("pedro123");

        Usuario usuario4 = new Usuario();
        usuario1.setUsuario("Pablo");
        usuario1.setPassword("Pablo123");

        lstUsuarios.add(usuario1);
        lstUsuarios.add(usuario2);
        lstUsuarios.add(usuario3);
        lstUsuarios.add(usuario4);

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(lstUsuarios,this);
        listViewUsuarios.setAdapter(usuarioAdapter);








    }
}
