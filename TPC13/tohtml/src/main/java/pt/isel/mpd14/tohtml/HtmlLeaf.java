package pt.isel.mpd14.tohtml;

/**
 * Created by Bruno on 20-05-2014.
 */
public class HtmlLeaf implements HtmlNode {
    private String name, params;
    private int nodeLvl;

    public HtmlLeaf(String name){
        this.name = name;
        this.params = null;
        this.nodeLvl = 0;
    }

    public HtmlLeaf(String name, int nodeLvl){
        this.name = name;
        this.params = null;
        this.nodeLvl = nodeLvl;
    }

    public HtmlLeaf(String name, String params){
        this.name = name;
        this.params = params;
        this.nodeLvl = 0;
    }

    public HtmlLeaf(String name, String params, int nodeLvl){
        this.name = name;
        this.params = params;
        this.nodeLvl = nodeLvl;
    }

    @Override
    public String print() {
        String tab = "";
        for(int i = 0; i < nodeLvl; i++)
            tab += "   ";
        if(params == null)
            return tab + "<" + name + ">\n";
        return tab + "<" + name + " " + params + ">\n";
    }

    @Override
    public void changeLvl(int lvl) {
        this.nodeLvl += lvl + 1;
    }
}
