/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.tohtml;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
class TextNode implements HtmlNode{
    private int nodeLvl;
    final String content;
    
    public TextNode(String content) {
        this.content = content;
        this.nodeLvl = 0;
    }

    public TextNode(String content, int nodeLvl) {
        this.content = content;
        this.nodeLvl = nodeLvl;
    }

    @Override
    public String print() {
        String tab = "";
        for(int i = 0; i < nodeLvl; i++)
            tab += "   ";

        return tab + content + "\n";
    }

    @Override
    public void changeLvl(int lvl) {
        this.nodeLvl += lvl + 1;
    }


}
