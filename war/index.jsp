<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gallerator plugin for itslearning</title>
    <link href="Styles/Site.css" rel="stylesheet" type="text/css" />
    <script src="Scripts/jquery-1.4.1.js" type="text/javascript"></script>
    <script src="Scripts/GalleryPlugins/Galleria/galleria.js" type="text/javascript"></script>
    <script src="Scripts/GalleryPlugins/SlidingGallery/scripts/jquery.slidingGallery-1.2.min.js" type="text/javascript"></script>
</head>
<body>
    <div class="page">
        <div class="main">
        <h2>
        Welcome to the Gallery Creator!
    </h2>
    <p>
        Upload or give us the URL to your images, and choose the gallery of your choice!
    </p>
    <div class="import">
        <div class="import-upload">
            <!-- <asp:FileUpload runat="server" ID="FileUpload" /> -->
        </div>
        <div class="import-separator">
        <span>or...</span>
        </div>
        <div class="import-metadata">
            <!--  <asp:Label runat="server" Text="URI of your image"></asp:Label>
            <asp:TextBox runat="server" ID="txtURI"></asp:TextBox> -->
        </div>
        <!-- <asp:Button Text="Submit" OnClick="SubmitImport" runat="server" /> -->
    </div>
    <!-- change this to bind the onchange in jquery -->
    <select id="gallerySelector">
        <option title="Choose one..." value="0" selected="selected">Choose one gallery...</option>
        <option title="Galleria" value="1">Galleria</option>
        <option title="Sliding gallery" value="2">Sliding gallery</option>
    </select>
    <div id="images" style="display:none;" class="">
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Basket_of_strawberries_red_accent.jpg/500px-Basket_of_strawberries_red_accent.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/2/2d/Ns1-unsharp.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Laser_effects.jpg/500px-Laser_effects.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/PizBernina3.jpg/500px-PizBernina3.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/4/47/La_Galera_2.jpg/500px-La_Galera_2.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Costa_rica_santa_elena_skywalk.jpg/500px-Costa_rica_santa_elena_skywalk.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Kuznetsk_Alatau_3.jpg/500px-Kuznetsk_Alatau_3.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Smoky_forest.jpg/500px-Smoky_forest.jpg" />
        <img alt="" class="originals" src="http://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Alcea_rosea_and_blue_sky.jpg/500px-Alcea_rosea_and_blue_sky.jpg" />
    </div>
    <div id="imageView" style="height: 400px; width: 800px; position:relative;" class="images">
    </div>
    <a href="#" id="htmlGeneratorButton">Generate html</a>
    <iframe id="iframeWithGallery" width="900px" height="600px" frameborder="1">
        
    </iframe>
    <script type="text/javascript">

        jQuery(document).ready(function ($) {
            $('#gallerySelector').bind('change', ChooseGallery);
            $('#htmlGeneratorButton').bind('click', GenerateIframeContent);
            ChooseGallery();


            // Inserts html to fck
            function InsertHtml(html) {
                document.getElementById('insertedHtml').value = html;
                document.getElementById('form').submit();
            }


            // Loads correct gallery and populates it with images from #images div
            function ChooseGallery() {


                CleanupGalleryModificationsAndPrepareForNewGallery();
                var images = $('#imageView');

                var selectedGallery = $("#gallerySelector").val();
                if (selectedGallery == "0") {
                    images.hide();
                }
                if (selectedGallery == "1") {
                    Galleria.loadTheme('Scripts/GalleryPlugins/Galleria/themes/classic/galleria.classic.js');
                    images.galleria();
                    images.show();
                }
                if (selectedGallery == "2") {
                    $('#imageView img:first').addClass('start');
                    $('#imageView img').slidingGallery({
                        container: $('div#imageView'),
                        Lshrink: function (dimension) { return dimension * 0.3; }
                    });
                }
            }

            // CLeanup of what different galleries have done
            function CleanupGalleryModificationsAndPrepareForNewGallery() {
                var imageList = $('#images').children().clone();
                $('#imageView').empty();
                imageList.appendTo('#imageView');
            }

            function GenerateIframeContent() {
                // Put the imageView content into the iframe
                $("#iframeWithGallery").contents().find("body").html($("<div></div>").append($("#imageView").clone()).html());
                $("#iframeWithGallery").contents().find("html head").html($('head').html());
                
                // TOOD: put scripts to head

            }
        });
    </script>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="footer">
        &copy; Trit 2010    
    </div>
</body>
</html>