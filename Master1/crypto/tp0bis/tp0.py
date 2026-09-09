from PIL import Image


image1 = 'sujet-0.png'

def extraction_image(image , couleur):
    img = Image.open(image).convert("RGBA")
    pixels = img.load()
    imageSortie = Image.new("1",img.size)
    for x in range(img.width):
        for y in range(img.height):
            (r,g,b,a) = pixels[x,y]
            p=0
            if(couleur =="rouge"):
                p = r & 1
            if(couleur == "vert"):
                p= g & 1
            if(couleur == "bleu"):
                p = b & 1
                
            if p == 1:
                imageSortie.putpixel((x,y),255)
            else:
                imageSortie.putpixel((x,y),0)
    imageSortie.save("extraction_image_" + couleur + ".png")


def cacher_image(imageHote, imageCacher, couleur):
    img_hote = Image.open(imageHote).convert("RGBA")
    img_cacher = Image.open(imageCacher).convert("RGBA")

    pixels_hote = img_hote.load()
    pixels_cacher = img_cacher.load()
    
    for x in range(img_hote.width):
        for y in range(img_hote.height):
            (r_h,g_h,b_h,a_h) = pixels_hote[x,y]
            (r_c,g_c,b_c,a_c) = pixels_cacher[x,y]
            if couleur == "rouge":
                bit_faible = r_c >> 7 & 1
                bit_fort = r_h & 11111110
                r_h = bit_faible | bit_fort
            elif couleur == "vert":
                bit_faible = g_c >> 7 & 1
                bit_fort = g_h & 11111110
                g_h = bit_faible | bit_fort
            elif couleur == "bleu":
                bit_faible = b_c >> 7 & 1
                bit_fort = b_h & 11111110
                b_h = bit_faible | bit_fort
            pixels_hote[x,y] = (r_h,g_h,b_h,a_h)
            
    img_hote.save("image_cacher_avec_hote_" + couleur + ".png")


# cacher_image("image-hote.png", "imageacacher.png", "rouge")

extraction_image("image_cacher_avec_hote_rouge.png", "rouge")