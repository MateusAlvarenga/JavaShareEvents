package com.iftm.util;

import java.util.ArrayList;
import java.util.List;

public class QueryService {

    List<String> colunas;
    List<String> valores;

    public QueryService() {
        this.colunas = new ArrayList<>();
        this.valores = new ArrayList<>();
    }

    public void addString(String coluna, String valor) {
        addParam(coluna, "'" + valor + "'");
    }
    
    public void addInt(String coluna, int valor) {
        addParam(coluna, String.valueOf(valor));
    }
    

    private void addParam(String coluna, String Valor) {
        colunas.add(coluna);
        valores.add(Valor);
    }

    public String getWhere() {
        String where = "WHERE ";

        while (true) {
            int cont = 0;
            where += colunas.get(cont) + " = " + valores.get(cont);

            if (cont < (colunas.size() - 1)) {
                where += " AND ";
            } else {
                break;
            }

        }
        return where;
    }

}
