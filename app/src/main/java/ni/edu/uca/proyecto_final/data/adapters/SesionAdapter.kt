package ni.edu.uca.proyecto_final.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.proyecto_final.R
import ni.edu.uca.proyecto_final.data.adapters.SesionAdapter.*
import ni.edu.uca.proyecto_final.data.entidades.Sesion
import ni.edu.uca.proyecto_final.data.entidades.SesionObj

class SesionAdapter(listaSesion: MutableList<Sesion>,private val onItemClicked: (Sesion) -> Unit) :   ListAdapter<Sesion, SesionViewHolder>(DiffCallback) {
    val listaSesion = listaSesion

    class SesionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFecha:TextView = itemView.findViewById(R.id.item_date)
        val tvUser:TextView = itemView.findViewById(R.id.item_user)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SesionViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.lista_sesion, null, false)
        return SesionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SesionViewHolder, position: Int) {
        val current =listaSesion[position]
        holder.tvUser.setOnClickListener {
            SesionObj.Id_Sesion=current.id_sesion
            onItemClicked(current)
        }

        holder.itemView.setOnClickListener {
            onItemClicked(current)
            SesionObj.Id_Sesion=current.id_sesion
        }

        holder.tvFecha.text = current.fecha_sesion
        holder.tvUser.text = current.nombre_usuario
    }

    override fun getItemCount(): Int {
        return listaSesion.size
    }
    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Sesion>() {
            override fun areItemsTheSame(oldItem: Sesion, newItem: Sesion): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Sesion, newItem: Sesion): Boolean {
                return oldItem.id_sesion == newItem.id_sesion
            }
        }
    }

}