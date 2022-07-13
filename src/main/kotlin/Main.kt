import com.appmattus.crypto.Algorithm
import org.opencv.core.Core
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.core.Scalar
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
            var arraylistB = ArrayList<String>()
            var arraylistH = ArrayList<String>()
            val bytes = File(it.path).readBytes()
            arraylistN.add(it.name)
            val inputString = Base64.getEncoder().encodeToString(bytes)
            arraylistB.add(inputString)
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
    File("src/main/resources/file11.txt").writeText(arraylistN.joinToString())
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

    System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
    println(Core.VERSION)
    val mat = Mat(5, 10, CvType.CV_8UC1, Scalar(0.0))
    println("OpenCV Mat: $mat")
    val mr1 = mat.row(1)
    mr1.setTo(Scalar(1.0))
    val mc5 = mat.col(5)
    mc5.setTo(Scalar(5.0))
    println("OpenCv Mat Data: \n${mat.dump()}")
}