# pdf2image-test

PDFファイルを画像(jpeg/png)へ変換するためのJavaライブラリ調査。

調査候補
- PDFBox
- OpenPDF
- iText

## PDFBox

PDF操作の総合ライブラリ。2016年リリースのVersion2から日本語対応。
ライセンスはApache License v2.0。

実装サンプルは
`src/main/kotlin/com/example/pdfbox/controller/PdfBoxController.kt`参照。

参考
- 公式 - https://pdfbox.apache.org/
- PDF Rendering - https://pdfbox.apache.org/2.0/migration.html#pdf-rendering
- PDFBoxを使ってPDFファイルを画像ファイル（JPEG）に変換する - https://code.st40.xyz/article/585
- Apache PDFBoxでPDFページを画像にする（ラスタライズ） - https://qiita.com/ota-meshi/items/812ebffa319b2bbde1c3

## OpenPDF

基本的にPDFを生成・編集するためのライブラリ。
ライセンスはLGPLもしくはMozilla Public License。

画像へ変換する機能は存在しない？（検索しても見当たらない）

参考
- 公式 - https://github.com/LibrePDF/OpenPDF

## iText

個人利用のみ無償利用化。 
pdfRenderのadd-onで画像変換可能だが、add-on利用には商用ライセンスが必要なため検証できず。

参考
- 公式 - https://itextpdf.com/
- pdfRender: BufferedImage as output format - https://kb.itextpdf.com/home/it7kb/examples/pdfrender-bufferedimage-as-output-format
