import com.appmattus.crypto.Algorithm
import java.io.File
import java.math.BigInteger
import java.util.*


fun main(args: Array<String>) {


    var arraylistHs = ArrayList<ArrayList<String>>()
    File("D:/Angie/universidad/2020/imagesdataset/VG_100K/").walk().forEach { it ->
        //println(it.extension + " is the extension of " + it.name)
        if (it.extension == "jpg")
        {
            var arraylistB = ArrayList<String>()
            var arraylistH = ArrayList<String>()
            val bytes = File(it.path).readBytes()
            val inputString = Base64.getEncoder().encodeToString(bytes)
            arraylistB.add(inputString)
            val stringByteArray = inputString.encodeToByteArray()
            val digest = Algorithm.XXHash64(0).createDigest()
            val hash = digest.digest(stringByteArray)
            var h: String? = null
            hash.forEach {

                val hexString = String.format("%X", it)
                // println(hexString)
                if (h == null)
                {
                    h = hexString
                }else {
                    h += hexString
                }
            }
            var ha = h.toString()
            ha.forEach {
                val decimalString = BigInteger(it.toString(), 16).toString()
                arraylistH.add(decimalString)
            }
            arraylistHs.add(arraylistH)
            println(arraylistH)
        }

    }

    File("src/main/resources/file2.txt").writeText(arraylistHs.toString())
    val filename = "file2.txt"

    var fileObject = File(filename)
    var s = fileObject.absolutePath
    var fileExists = fileObject.exists()
    if(fileExists){
        println("$filename file2 does exist.")
    } else {
        println("$filename file2 does not exist.")
    }
    //val bufferedReader = File("src/base64.txt").bufferedReader()
    //val inputString = bufferedReader.use { it.readText() }

    //val stringByteArray = inputString.encodeToByteArray()
    //val digest = Algorithm.XXHash64(0).createDigest()
    //val hash = digest.digest(stringByteArray)


}