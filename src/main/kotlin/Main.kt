import com.appmattus.crypto.Algorithm
import java.awt.Image
import java.io.File
import java.math.BigInteger
import java.util.*


fun main(args: Array<String>) {


    var arraylistHs = ArrayList<ArrayList<String>>()
    var arraylistN = ArrayList<String>()
    //File("D:/Angie/trabajoimagenes/in-img/tensor/").walk().forEach { it ->
    //File("D:/Angie/universidad/2020/imagesdataset/VG_100K/").walk().forEach { it ->
    File("D:/Angie/trabajoimagenes/org-img/impresas/").walk().forEach { it ->
        //println(it.extension + " is the extension of " + it.name)
        if (it.extension == "png")
        {

            var arraylistH = ArrayList<String>()
            println(s)
            val bytes = File(it.path).readBytes()
            arraylistN.add(it.name)
            val inputString = Base64.getEncoder().encodeToString(bytes)
            var arraylistB=inputString
            File("src/main/resources/file1111.txt").writeText(arraylistB)
            val stringByteArray = inputString.encodeToByteArray()
            val digest = Algorithm.XXHash64(0).createDigest()
            val hash = digest.digest(stringByteArray)
            var h: String? = null
            hash.forEach {

                val hexString = String.format("%X", it)
                //print(hexString)
                if (h == null)
                {
                    h = hexString
                }else {
                    h += hexString
                }
            }

            var ha = h.toString()
            while(ha.length < 16)
            {
                //println(ha.length)
                ha += "0"
            }
            //println(ha)

            ha.forEach {
                val decimalString = BigInteger(it.toString(), 16).toString()
                arraylistH.add(decimalString)
            }
            arraylistHs.add(arraylistH)
            //println(arraylistH)
        }

    }

    File("src/main/resources/file1.txt").writeText(arraylistHs.joinToString())
   // File("src/main/resources/file1111.txt").writeText(arraylistB.joinToString())
    val filename = "file3.txt"

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