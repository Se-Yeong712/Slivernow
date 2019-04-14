package s2017s16.kr.hs.mirim.silvernow

interface ItemActionListener {
    fun onItemMoved(from: Int, to: Int)
    fun onItemSwiped(position: Int)
}