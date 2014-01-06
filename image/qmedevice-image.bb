# Image to interact with devices that quantify me (qmedevices).
# Target should boot quickly, have ssh, and libraries to connect 
# medevices to remote drivers using currently named insulware package
# via cellular modems.
# Target runs a service that serves pages over a USB OTG network interface
# to register the machine with a web service that can negotiate with USB attached
# devices without hosting device drivers locally. It's an embedded appliance to
# attach USB connected devices to a remote service.
#
# There's still some dev tools in here, like screen, vim, git...

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

IMAGE_FEATURES = "ssh-server-openssh \
                package-management \
                debug-tweaks \
                "
# core package groups
IMAGE_INSTALL = "packagegroup-core-boot \
                packagegroup-base-usbhost \
                packagegroup-base-usbgadget \
                packagegroup-core-ssh-openssh \
                ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
                ${CORE_IMAGE_EXTRA_INSTALL} \
                systemd-analyze \
                "

# We want some extras
IMAGE_INSTALL += "usb-modeswitch ppp udev-hso \
        socat curl avahi nodejs dnsmasq \
		cmgpy insulware \
        vim screen git "

IMAGE_DEV_MANAGER   = "udev"
IMAGE_INIT_MANAGER  = "systemd"
IMAGE_INITSCRIPTS   = " "
IMAGE_LOGIN_MANAGER = "busybox shadow"

export IMAGE_BASENAME = "qmedevice-image"

inherit core-image
