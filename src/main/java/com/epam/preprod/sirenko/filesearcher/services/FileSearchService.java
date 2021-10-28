package com.epam.preprod.sirenko.filesearcher.services;

import java.io.File;
import java.util.List;

public interface FileSearchService {
	List<File> fileSearch(File file);
}
