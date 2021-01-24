package com.example.pdfbox

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import org.apache.pdfbox.tools.imageio.ImageIOUtil
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*
import javax.imageio.ImageIO

@Controller
class HtmlController {
    @GetMapping("/")
    fun index(model: Model): String {
        model["title"] = "PDFBox"
        model["isSubmitted"] = false
        return "index"
    }

    @PostMapping("/")
    fun submit(
        model: Model,
        @RequestParam("upload_file") multipartFile: MultipartFile
    ): String {
        val document : PDDocument = PDDocument.load(multipartFile.inputStream)
        val pdfRenderer : PDFRenderer = PDFRenderer(document)
        val bim : BufferedImage = pdfRenderer.renderImageWithDPI(0, 300f, ImageType.RGB)
        val baos: ByteArrayOutputStream = ByteArrayOutputStream()
//        ImageIOUtil.writeImage(bim, "output.png", 300)
        ImageIO.write(bim, "png", baos)
        baos.flush()

        model["title"] = "PDFBox Submitted"
        model["isSubmitted"] = true
        model["base64"] = Base64.getEncoder().encodeToString(baos.toByteArray())
        return "index"
    }
}