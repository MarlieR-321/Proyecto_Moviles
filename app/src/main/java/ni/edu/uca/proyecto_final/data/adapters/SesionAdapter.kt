package ni.edu.uca.proyecto_final.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.proyecto_final.R
import ni.edu.uca.proyecto_final.data.adapters.SesionAdapter.*
import ni.edu.uca.proyecto_final.data.entidades.Sesion

class SesionAdapter(listaSesion: MutableList<Sesion>): RecyclerView.Adapter<SesionViewHolder>() {
    val listaSesion = listaSesion

    class SesionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvFecha:TextView = itemView.findViewById(R.id.item_nae)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SesionViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.lista_sesion, null, false)
        return SesionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SesionViewHolder, position: Int) {
        holder.tvFecha.text = listaSesion[position].fecha_sesion

    }

    override fun getItemCount(): Int {
        return listaSesion.size
    }

}