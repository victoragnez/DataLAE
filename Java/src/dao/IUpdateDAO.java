/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Publicacao;
import service.model.Relatorio;
import service.model.Viagem;

public interface IUpdateDAO {
    public void updateProjeto(Projeto p);
    public void updateArea(Projeto p, Area a);
    public void updateViagem(Projeto p, Area a, Viagem v);
    public void updatePublicacao(Projeto p, Publicacao pb);
    public void updateRelatorio(Projeto p, Boolean Final, Relatorio r);
}
