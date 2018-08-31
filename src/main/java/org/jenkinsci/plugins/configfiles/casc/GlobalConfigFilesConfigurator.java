package org.jenkinsci.plugins.configfiles.casc;

import org.jenkinsci.plugins.configfiles.GlobalConfigFiles;

import hudson.Extension;
import hudson.model.Descriptor;
import io.jenkins.plugins.casc.Attribute;
import io.jenkins.plugins.casc.ConfigurationContext;
import io.jenkins.plugins.casc.RootElementConfigurator;
import io.jenkins.plugins.casc.impl.configurators.DescriptorConfigurator;
import io.jenkins.plugins.casc.model.CNode;
import io.jenkins.plugins.casc.model.Mapping;
import jenkins.model.Jenkins;

/**
 * {@link RootElementConfigurator} to handle {@link GlobalConfigFiles}</code>.
 *
 * @author srempfer
 */
@Extension
public class GlobalConfigFilesConfigurator extends DescriptorConfigurator {

    public GlobalConfigFilesConfigurator() {
        super(Jenkins.getInstance().getDescriptor(GlobalConfigFiles.class));
    }

    @Override
    public CNode describe(Descriptor instance, ConfigurationContext context) throws Exception {
        // normal mechanism which compares the current instance and a new instance of it could not be used here
        // the configs are loaded in constructor of the descriptor and so all configs are treated as default values
        // which are not described/ exported
        Mapping mapping = new Mapping();
        for (Attribute attribute : getAttributes()) {
            mapping.put(attribute.getName(), attribute.describe(instance, context));
        }
        return mapping;
    }
}
