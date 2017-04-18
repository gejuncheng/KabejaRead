package service;

import org.kabeja.dxf.*;
import org.kabeja.parser.DXFParser;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/4/13.
 */
public class DXF_Extract {

    public void parseFile(String sourceFile){

        Parser parser = ParserBuilder.createDefaultParser();
        StringBuffer str = new StringBuffer();
        DXFLayer layer;
        List<Object> text = new ArrayList<Object>();
        List<Object> mtext = new ArrayList<Object>();

        try {
            FileInputStream in = new FileInputStream(new File(sourceFile));
            //预解析
            parser.parse(in,"UTF-8");
            //获取文本和图层
            DXFDocument doc = parser.getDocument();
            Iterator<?> it = doc.getDXFLayerIterator();
            while(it.hasNext()){
                layer = (DXFLayer) it.next();

                text = layer.getDXFEntities(DXFConstants.ENTITY_TYPE_TEXT);
                if (text != null){
                    for (int i = 0;i < text.size();i++){
                        String a = ((DXFText)(text.get(i))).getText();
                        if (a != null && !"".equals(a.trim())){
                            a = a.replaceAll(" ","");
                            str.append(a);
                        }
                        System.out.println("text值："+a);
                    }
                }

                mtext = layer.getDXFEntities(DXFConstants.ENTITY_TYPE_MTEXT);
                if (mtext != null){
                    for (int i = 0;i < text.size();i++){
                        String a = ((DXFText)(text.get(i))).getText();
                        if (a != null && !"".equals(a.trim())){
                            a = a.replaceAll(" ","");
                            str.append(a);
                        }
                        System.out.println("mtext值："+a);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(str.toString());

    }
}
