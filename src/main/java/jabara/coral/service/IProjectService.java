/**
 * 
 */
package jabara.coral.service;

import jabara.coral.entity.EProject;
import jabara.coral.service.impl.ProjectServiceImpl;

import com.google.inject.ImplementedBy;

/**
 * @author jabaraster
 */
@ImplementedBy(ProjectServiceImpl.class)
public interface IProjectService {

    /**
     * @param pProject
     */
    void insert(EProject pProject);
}
