package pe.com.tizen.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pe.com.tizen.login.R;
import pe.com.tizen.login.entity.Usuario;

/**
 * Created by Alumnos on 21/04/2015.
 */
public class UsuarioAdapter extends BaseAdapter{

    private Context context;
    private List<Usuario> lstUsuarios;


    public UsuarioAdapter(List<Usuario> lstUsuarios, Context context){
        this.lstUsuarios = lstUsuarios;
        this.context = context;
    }


    @Override
    public int getCount() {
        return lstUsuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return lstUsuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.pagina_inicio,null);
        }

        TextView titusuario = (TextView)convertView.findViewById(R.id.txtConfirmacion);


        Usuario usuario = lstUsuarios.get(position);
        titusuario.setText("Renato");


        return convertView;
    }
}
