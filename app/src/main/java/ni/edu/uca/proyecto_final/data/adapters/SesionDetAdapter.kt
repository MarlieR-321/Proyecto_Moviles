package ni.edu.uca.proyecto_final.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.proyecto_final.R
import ni.edu.uca.proyecto_final.data.entidades.Sesion_Detalles

class SesionDetAdapter(ListaSesionDet:MutableList<Sesion_Detalles>):RecyclerView.Adapter<SesionDetAdapter.SesionDetViewHolder>() {
    val Lista_Sesion_Det= ListaSesionDet
    class SesionDetViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val tvEjercicio:TextView=itemView.findViewById(R.id.item_ejercicio)
        val tvRepeticiones:TextView=itemView.findViewById(R.id.item_rep)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SesionDetViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.lista_detalle, null, false)
        return SesionDetAdapter.SesionDetViewHolder(view)
    }
    override fun getItemCount(): Int {
        return Lista_Sesion_Det.size
    }

    override fun onBindViewHolder(holder: SesionDetViewHolder, position: Int) {
        val current=Lista_Sesion_Det[position]
        holder.tvEjercicio.text=current.nombre_ejercicio
        holder.tvRepeticiones.text=current.repeticiones
    }
}