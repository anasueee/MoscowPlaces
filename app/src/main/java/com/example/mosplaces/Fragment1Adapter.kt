package com.example.mosplaces

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mosplaces.databinding.CardItemBinding

class Fragment1Adapter : RecyclerView.Adapter<Fragment1Adapter.CardViewHolder>() {
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
            "Иван-чайное купе",
            "Тайная комната",
            "Бункер-42",
            "Слёзы Берёзы"
        )
        private val DESCRIPTIONS = mutableListOf(
            "Здесь все напоминает купе поезда: специальные дорожные места для пассажиров с латунными номерками и окошками-фотографиями начала XX века, рыжий уютный диван, на стенах оригинальные старинные карты и облигации железных дорог Российской Империи, венские стулья, плитка с орнаментами, старинные светильники и длинные бархатные  шторы, деревянная отделка и десятки полок с подарками, которые можно захватить для любимых.\n" + "\n" + "Время работы: 10:00 - 22:00\n" + "\n" + "Адрес: ул. Садовническая, 80",
            "Аутентичный готический паб «Тайная комната» находится на Солянке и попасть в него можно через не менее аутентичный Black Swan. Почти двести квадратных метров красоты условно разделены на 5 залов: паб, собор, винный погреб, колокольня (с настоящим казарменным колоколом XIX века) и трапезная. Перевести дух и подумать о хлебе насущном предлагают за обилием пивных закусок, блюд из мяса и морепродуктов. За баром — несколько видов пива, авторские коктейли и крепкий алкоголь.\n" + "\n" + "Время работы: 12:00 - 00:00\n" + "\n" + "Адрес: ул. Солянка, 1/2с1",
            "Ресторан «Бункер-42» находится на глубине 65 метров и, если верить описанию на сайте, представляет собой «фортификационное сооружение в самом центре Москвы». Прочие детали и захватывающие дух истории вам поведает команда ресторана. В меню будет русская кухня: соленья, борщ, салат оливье, а также любимые блюда лидеров СССР.\n" + "\n" + "Время работы: 13:00 - 23:00\n" + "\n" + "Адрес: пер. 5-й Котельнический, 11",
            "Бар «Слезы березы» расположился на «Бауманской» и являет собой оплот любви к Родине. Здесь вместо диванов — распиленные ванные, вместо абажуров — шали, заботливо наброшенные на плечи абажуров и стволы берез под сводами потолка. В меню, разумеется, борщ, макароны по-флотски и другие родные и любимые блюда. За баром, облицованным фасадом сгоревшей избы, разливают сидр и пиво.\n" + "\n" + "Время работы: 15:00 - 00:00\n" + "\n" + "Адрес: ул. Бауманская, 15"
        )
        private val IMAGES = mutableListOf(
            R.drawable.ivantea,
            R.drawable.taynaya,
            R.drawable.bunker,
            R.drawable.slezi
        )
    }
}