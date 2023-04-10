package com.example.mosplaces

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mosplaces.databinding.CardItemBinding

class Fragment3Adapter : RecyclerView.Adapter<Fragment3Adapter.CardViewHolder>() {
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
            "Музей психиатрической больницы им. Алексеева",
            "Подпольная типография 1905-1906 гг.",
            "Церковь Климента Папы Римского",
            "Благовещенский собор"
        )
        private val DESCRIPTIONS = mutableListOf(
            "Все интересное, что происходило в этой психиатрической больнице за последние сто с лишним лет, задокументировано в музее. Под музей здесь переделали реальные больничные палаты и в трех выставочных залах собрали самые разные артефакты — от реальных историй болезни до поделок пациентов из цеха трудовой терапии.\n" + "\n" + "Время работы: 10:00 - 15:00\n" + "\n" + "Адрес: ш. Загородное, 2, стр. 1Б",
            "Из торгового зала со старинными витринами сегодня можно спуститься в подвал и увидеть там идеализированный интерьер — ящики с фруктами и сыром, на дне которых лежат стопки запрещенных газет и агиток. Кроме подвала можно сходить на кухню и в жилую комнату подпольщиков, увидеть старинную швейную машинку, кухонную утварь и другие предметы быта, а заодно ощутить полное погружение в жизнь революционера начала прошлого века.\n" + "\n" + "Время работы: 11:00 - 19:00\n" + "\n" + "Адрес: ул. Лесная, 55",
            "На Пятницкой улице в Москве ощущается особенная атмосфера. Сюда нужно приходить для того чтобы познакомиться с историей Замоскворечья и увидеть голубые купола храма, освященного в честь Климента Папы Римского и священномученика. Его красота поистине необыкновенна, ведь в архитектуре прослеживаются черты подлинного церковного барокко. В храме хранятся совсем нетипичные для православного зодчества иконостасы. Центральный из них изготовлен из дерева и украшен красивыми скульптурами.\n" + "\n" + "Время работы: 08:30 - 19:00\n" + "\n" + "Адрес: ул. Пятницкая, 26, стр. 1",
            "Старинное православное строение, возведенное во второй половине XIV века, считалось домовым храмом представителей царской семьи: здесь крестили, венчали и отпевали членов правящей династии. Первую деревянную церквушку построил сын Дмитрия Донского прямо около входа в дом, где проживало семейство царя, и лишь через столетие, по велению Ивана III на этом месте возвели собор из камня. Росписью стен занимались известнейшие русские умельцы: Андрей Рублев и Феофан Грек. Благодаря их мастерству, внутренне убранство собора поражает великолепием ликов святых.\n" + "\n" + "Время работы: 10:00 - 16:30\n" + "\n" + "Адрес: наб. Кремлёвская, 1, стр. 8"
        )
        private val IMAGES = mutableListOf(
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4
        )
    }
}