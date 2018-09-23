/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.Area;
import service.Pesquisa;
import service.Viagem;

public interface IRemoveDAO {
	public void removePesquisa(Pesquisa p);
    public void removeArea(Pesquisa p, Area a);
    public void removeViagem(Pesquisa p, Area a, Viagem v);
}
