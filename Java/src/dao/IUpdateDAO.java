/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.Area;
import service.model.Pesquisa;
import service.model.Viagem;

public interface IUpdateDAO {
    public void updatePesquisa(Pesquisa p);
    public void updateArea(Pesquisa p, Area a);
    public void updateViagem(Pesquisa p, Area a, Viagem v);
}
