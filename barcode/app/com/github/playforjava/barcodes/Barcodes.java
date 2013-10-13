package com.github.playforjava.barcodes;

import org.krysalis.barcode4j.impl.upcean.EAN13Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import play.mvc.Controller;
import play.mvc.Result;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Barcodes extends Controller {

  public static Result barcode(String ean) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    BitmapCanvasProvider provider = new BitmapCanvasProvider(out,
        "image/png", 144, BufferedImage.TYPE_BYTE_BINARY, false, 0);
    
    try {
      new EAN13Bean().generateBarcode(provider, ean);
      provider.finish();
      return ok(out.toByteArray());
    } catch (IOException e) {
      return badRequest("Could not render barcode. " + e.getMessage());
    } finally {
      try { out.close(); } catch(Exception e) {}
    }
  }
}
