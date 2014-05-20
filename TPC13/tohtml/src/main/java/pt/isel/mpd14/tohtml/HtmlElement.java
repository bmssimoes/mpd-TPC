/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public class HtmlElement implements HtmlNode{
    private final String name;
    private final List<HtmlNode> children;
    private int nodeLvl;

    public HtmlElement(String name) {
        this.name = name;
        children = new LinkedList<HtmlNode>();
        this.nodeLvl = 0;
    }

    public HtmlElement(String name, int nodeLvl) {
        this.name = name;
        children = new LinkedList<HtmlNode>();
        this.nodeLvl = nodeLvl;
    }
    
    public HtmlElement(String name, String content) {
        this.name = name;
        children = new LinkedList<HtmlNode>();
        this.nodeLvl = 0;
        add(new TextNode(content));
    }

    public HtmlElement(String name, String content, int nodeLvl) {
        this.name = name;
        children = new LinkedList<HtmlNode>();
        this.nodeLvl = nodeLvl;
        add(new TextNode(content));
    }
    
    public void add(HtmlNode elem){
        elem.changeLvl(nodeLvl);
        children.add(elem);
    }

    public void changeLvl(int lvl){
        this.nodeLvl += lvl + 1;
        for (HtmlNode n : children) {
            n.changeLvl(nodeLvl);
        }
    }

    public String print(){
        String res, tab = "";
        for(int i = 0; i < nodeLvl; i++)
            tab += "   ";

        res = tab + "<" + name + ">\n";
        for (HtmlNode n : children) {
            res += n.print();
        }
        res += tab + "</" + name + ">\n";
        return res;
    }
}
