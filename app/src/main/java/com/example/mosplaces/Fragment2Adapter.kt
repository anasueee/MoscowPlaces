package com.example.mosplaces

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mosplaces.databinding.CardItemBinding

class Fragment2Adapter : RecyclerView.Adapter<Fragment2Adapter.CardViewHolder>() {
    private var cards = mutableListOf<Card>()
    init {
        cards = (0..3).map {
            Card(
                id = it.toLong(),
                header = HEADERS[it % HEADERS.size],
                description = DESCRIPTIONS[it % DESCRIPTIONS.size],
                image = IMAGES[it % IMAGES.size]
            )
        }.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardItemBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = data[position]
        val context = holder.itemView.context

        with(holder.binding) {
            headerCard.text = card.header
            descriptionCard.text = card.description
            imageCard.setImageResource(card.image)
        }
    }

    var data: List<Card> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CardViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    fun getCards(): List<Card> = cards

    companion object{
        private val HEADERS = mutableListOf(
            "Нескучный сад",
            "Екатерининский парк",
            "Двор собора Петра и Павла",
            "Сад будущего"
        )
        private val DESCRIPTIONS = mutableListOf(
            "Нескучный сад, который расположен по правому берегу Москвы-реки, на сегодняшний день наиболее часто рассматривается в качестве части парка Горького. Данный красивейший столичный парк является одним из наиболее старейших в Москве и находится под охраной государства. Название парк получил от одноименной старинной усадьбы Нескучное князя Трубецкого, которая была построена на территории современного парка.\n" + "\n" + "Время работы: круглосуточно\n" + "\n" + "Адрес: пр. Ленинский",
            "Парк расположен возле станции столичного метрополитена под названием «Достоевская». До пятнадцатого века данная территория отличалась только наличием цепочки прудов, которые были расположены вдоль Напрудной речки. Но со временем сюда был перенесен Крестовоздвиженский монастырь и каменная церковь Иоанна Воина. Именно в этом месте была построена усадьба графа Салтыкова. Название парк получил по причине нахождения на территории Екатерининского института благородных девиц. В советское время было вырублено огромное количество насаждений парка во время подготовки к олимпиаде. Тогда был построен стадион «Олимпийский». Из-за этого была напрочь уничтожена старая застройка Мещанского района столицы Российской Федерации.\n" + "\n" + "Время работы: 07:00 - 23:00\n" + "\n" + "Адрес: ул. Большая Екатерининская, 27",
            "Территорию вокруг сложно назвать полноценным сквером, рассчитанным на отдых горожан, но на лужайках и лавочках прохожие часто учат английский, читают и просто наслаждаются московским солнцем. По субботам и воскресеньям в соборе проводят органные концерты. В теплое время года в на присоборном участке буйно цветет сирень и гортензии. Если внимательно обойти территорию, можно полюбоваться древней кирпичной кладкой и арками, которые служат проходом.\n" + "\n" + "Время работы: 08:00 - 20:00\n" + "\n" + "Адрес: пер. Петропавловский, 4-6с8",
            "Сейчас на территории бывшей усадьбы можно найти старинную липовую аллею, декоративный пруд, созданный 200 лет назад и церковь Ризоположения. Во время прогулки между старыми деревьями можно заметить дуб, окруженный цепью и небольшими столбиками - считается, что его возраст приближается к 300 годам, поэтому растение занесено в программу защиты великовозрастных деревьев. \n" + "\n" + "Время работы: круглосуточно\n" + "\n" + "Адрес: 2-й пр. Леонова"
        )
        private val IMAGES = mutableListOf(
            R.drawable.neskuchniy,
            R.drawable.ekaterinskiy,
            R.drawable.dvor,
            R.drawable.sad
        )
    }
}