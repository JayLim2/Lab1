/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protocol;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ���������
 */
@XmlRootElement
public class ViewBooksPacket extends CommandPacket {
    
    public ViewBooksPacket(){}
    
    public ViewBooksPacket(Commands command){
        super(command);
    }
}
