import kotlin.random.Random

data class Gopher(
    val age:Int,
    val power:Int,
    val height:Int
)

class GopherRaceGenerator{
    fun generate(minGopherCount:Int,maxGopherCount:Int):List<Gopher> {
        val gopherRace:MutableList<Gopher> = mutableListOf()
        for(i in minGopherCount..maxGopherCount){
            gopherRace.add(
                Gopher(
                    Random.nextInt(1,1000),
                    Random.nextInt(1,1000),
                    Random.nextInt(1,1000)
                ))
        }
        return gopherRace.toList()
    }
}

fun main(args:Array<String>){
    val gopherGenerator = GopherRaceGenerator()
    val gophers = gopherGenerator.generate(1,10)
    gophers.forEach { println("Height :"+it.height +"\n" + "Age :"+it.age+"\n" +"Power :"+it.power+"\n") }
}