/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

public interface IRemoveDAO {
	public void removeProjeto(Projeto p);
    public void removeArea(Projeto p, Area a);
    public void removeViagem(Projeto p, Area a, Viagem v);
}
