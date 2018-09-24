/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import service.model.Area;
import service.model.Projeto;
import service.model.Viagem;

import java.util.ArrayList;

public interface IQueryDAO {
	public ArrayList<Projeto> queryProjetos();
	public ArrayList<Area> queryArea(Projeto p);
	public ArrayList<Viagem> queryViagem(Area a);
}
