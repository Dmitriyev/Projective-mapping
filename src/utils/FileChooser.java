/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author nikita
 */
public class FileChooser {

    public File selectFile() {
        File file = new File("defaultPath");
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Выберите файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileopen.getSelectedFile();
        }
        return file;
    }
}
