package com.liulishuo.filedownloader.file

import android.net.Uri
import android.util.Log
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.After
import org.junit.Before
import org.junit.Rule

import org.junit.Assert.*
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Matchers.anyString
import org.mockito.Mockito
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

/**
 * Created by bag on 05.12.16.
 */
@RunWith(PowerMockRunner::class)
@PrepareForTest(Uri::class)
class FactoryTest {

    @Rule @JvmField
    var tempFolder = TemporaryFolder()

    var factory = FileWrapper.Factory(null)

    @Test
    fun `pass file string - return java File wrapper`(){
        val file = tempFolder.newFile()
        val wrapper = factory.bakeFileWrapper(file.path)
        assertThat(wrapper, instanceOf(JavaFileWrapper::class.java))
    }

    @Test
    fun `pass URI string - return DocumentFile wrapper`(){
        PowerMockito.mockStatic(Uri::class.java)
        val uri = mock(Uri::class.java)
        Mockito.`when`(Uri.parse(anyString())).thenReturn(uri)

        val uriString = "content://localhost/etc/fstab"
        val wrapper = factory.bakeFileWrapper(uriString)
        assertThat(wrapper, instanceOf(DocumentFileWrapper::class.java))
        //assertThat(wrapper.)
    }

}