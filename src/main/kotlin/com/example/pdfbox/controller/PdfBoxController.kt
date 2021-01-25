package com.example.pdfbox.controller

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.rendering.ImageType
import org.apache.pdfbox.rendering.PDFRenderer
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.util.*
import javax.imageio.ImageIO

@Controller
class PdfBoxController {
    @GetMapping("/pdfbox")
    fun index(model: Model): String {
        model["title"] = "PDFBox Test"
        return "pdfbox"
    }

    @PostMapping("/pdfbox")
    fun submit(
        model: Model,
        @RequestParam("upload_file") multipartFile: MultipartFile
    ): String {
        model["title"] = "PDFBox Test"

        var document: PDDocument
        try {
            document = PDDocument.load(multipartFile.inputStream)
        } catch (e: Exception) {
            model["message"] = "File Error"
            return "pdfbox"
        }

        val pdfRenderer = PDFRenderer(document)
        model["base64images"] = (1..document.numberOfPages).map {
            getImageBase64(pdfRenderer, it)
        }
        return "pdfbox"
    }

    private fun getImageBase64(pdfRenderer: PDFRenderer, pageNum: Int): String {
        val bufferedImage : BufferedImage = pdfRenderer.renderImageWithDPI(pageNum - 1, 300f, ImageType.RGB)
        val byteArrayOutputStream = ByteArrayOutputStream()
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream)
        byteArrayOutputStream.flush()
        return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray())
    }
}